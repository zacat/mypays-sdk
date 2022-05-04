package com.zoeyun.mypays.sdk.common.redis.lock;

import com.github.jedis.lock.JedisLock;
import com.zoeyun.mypays.sdk.common.exception.MypaysRuntimeException;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.connection.Pool;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 实现简单的jedis分布锁
 */
public class JedisDistributedLock implements Lock {

    private final Pool<Jedis> jedisPool;
    private final JedisLock lock;

    public JedisDistributedLock(Pool<Jedis> jedisPool, String key) {
        this.jedisPool = jedisPool;
        this.lock = new JedisLock(key);
    }

    @Override
    public void lock() {
        try (Jedis jedis = jedisPool.getResource()) {
            if (!lock.acquire(jedis)) {
                throw new MypaysRuntimeException("acquire timeouted");
            }
        } catch (InterruptedException e) {
            throw new MypaysRuntimeException("lock failed", e);
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        try (Jedis jedis = jedisPool.getResource()) {
            if (!lock.acquire(jedis)) {
                throw new MypaysRuntimeException("acquire timeouted");
            }
        }
    }

    @Override
    public boolean tryLock() {
        try (Jedis jedis = jedisPool.getResource()) {
            return lock.acquire(jedis);
        } catch (InterruptedException e) {
            throw new MypaysRuntimeException("lock failed", e);
        }
    }

    @Override
    public boolean tryLock(long l, @NotNull TimeUnit timeUnit) throws InterruptedException {
        try (Jedis jedis = jedisPool.getResource()) {
            return lock.acquire(jedis);
        }
    }

    @Override
    public void unlock() {
        try (Jedis jedis = jedisPool.getResource()) {
            lock.release(jedis);
        }
    }

    @NotNull
    @Override
    public Condition newCondition() {
        throw new MypaysRuntimeException("unsupported method");
    }
}
