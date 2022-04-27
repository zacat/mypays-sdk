package com.zoeyun.mypays.sdk.config.impl;

import com.zoeyun.mypays.sdk.common.redis.RedisOps;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@Data
@EqualsAndHashCode(callSuper = false)
public class MypaysRedisConfigImpl extends MypaysDefaultConfigImpl {

    private static final String ACCESS_TOKEN_KEY_TPL = "%s:access_token:%s";
    private static final String LOCK_KEY_TPL = "%s:lock:%s:";

    private final RedisOps redisOps;
    private final String keyPrefix;

    private String accessTokenKey;
    private String lockKey;

    public MypaysRedisConfigImpl(RedisOps redisOps, String keyPrefix) {
        this.redisOps = redisOps;
        this.keyPrefix = keyPrefix;
    }

    @Override
    public void setClientId(String clientId) {
        super.setClientId(clientId);
        this.accessTokenKey = String.format(ACCESS_TOKEN_KEY_TPL, this.keyPrefix, clientId);
        this.lockKey = String.format(LOCK_KEY_TPL, this.keyPrefix, clientId);
        accessTokenLock = this.redisOps.getLock(lockKey.concat("accessTokenLock"));
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
     * Gets access token.
     *
     * @return the access token
     */
    @Override
    public String getAccessToken() {
        return redisOps.getValue(this.accessTokenKey);
    }

    @Override
    public boolean isAccessTokenExpired() {
        Long expire = redisOps.getExpire(this.accessTokenKey);
        return expire == null || expire < 2;
    }

    @Override
    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        redisOps.setValue(this.accessTokenKey, accessToken, expiresInSeconds - 200, TimeUnit.SECONDS);
    }

    @Override
    public void expireAccessToken() {
        redisOps.expire(this.accessTokenKey, 0, TimeUnit.SECONDS);
    }

}
