package com.zoeyun.mypays.sdk.common.redis;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public interface RedisOps {

    String getValue(String key);

    void setValue(String key, String value, int expire, TimeUnit timeUnit);

    Long getExpire(String key);

    void expire(String key, int expire, TimeUnit timeUnit);

    Lock getLock(String key);
}
