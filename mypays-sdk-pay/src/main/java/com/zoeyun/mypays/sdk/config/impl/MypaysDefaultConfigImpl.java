package com.zoeyun.mypays.sdk.config.impl;

import com.zoeyun.mypays.sdk.config.MypaysConfigStorage;
import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class MypaysDefaultConfigImpl implements MypaysConfigStorage, Serializable {

    private static final String DEFAULT_PAY_BASE_URL = "http://test.mypays.cn";
    private static final String DEFAULT_SANDBOX_PAY_BASE_URL = "http://test.mypays.cn";

    protected volatile String clientId;
    protected volatile String clientSecret;
    protected volatile String rsaPubKey;
    protected volatile String rsaPriKey;
    protected volatile int httpConnectionTimeout = 5000;
    private int httpTimeout = 10000;
    private boolean isUseSandboxEnv = false;
    protected volatile String accessToken;
    protected volatile long expiresTime;
    protected volatile Lock accessTokenLock = new ReentrantLock();

    @Override
    public Boolean getIsUseSandboxEnv() {
        return isUseSandboxEnv;
    }

    @Override
    public String getPayBaseUrl() {
        if (isUseSandboxEnv) {
            return DEFAULT_SANDBOX_PAY_BASE_URL;
        }
        return DEFAULT_PAY_BASE_URL;
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    @Override
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Gets access token lock.
     *
     * @return the access token lock
     */
    @Override
    public Lock getAccessTokenLock() {
        return accessTokenLock;
    }

    /**
     * Is access token expired boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isAccessTokenExpired() {
        return System.currentTimeMillis() > this.expiresTime;
    }

    /**
     * 强制将access token过期掉.
     */
    @Override
    public void expireAccessToken() {
        this.expiresTime = 0;
    }

    /**
     * 应该是线程安全的.
     *
     * @param accessToken      新的accessToken值
     * @param expiresInSeconds 过期时间，以秒为单位
     */
    @Override
    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + (expiresInSeconds - 200) * 1000L;
    }
}
