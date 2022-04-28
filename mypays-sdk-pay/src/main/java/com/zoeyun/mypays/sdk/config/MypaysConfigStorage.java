package com.zoeyun.mypays.sdk.config;

import java.util.concurrent.locks.Lock;

public interface MypaysConfigStorage {

    String getClientId();

    String getClientSecret();

    String getRsaPubKey();

    String getRsaPriKey();

    Boolean getUseSandboxEnv();

    String getPayBaseUrl();

    String getMerchantCode();

    /**
     * Gets access token.
     *
     * @return the access token
     */
    String getAccessToken();

    int getHttpConnectionTimeout();

    int getHttpTimeout();

    /**
     * Gets access token lock.
     *
     * @return the access token lock
     */
    Lock getAccessTokenLock();

    /**
     * Is access token expired boolean.
     *
     * @return the boolean
     */
    boolean isAccessTokenExpired();

    /**
     * 强制将access token过期掉.
     */
    void expireAccessToken();


    /**
     * 应该是线程安全的.
     *
     * @param accessToken      新的accessToken值
     * @param expiresInSeconds 过期时间，以秒为单位
     */
    void updateAccessToken(String accessToken, int expiresInSeconds);
}
