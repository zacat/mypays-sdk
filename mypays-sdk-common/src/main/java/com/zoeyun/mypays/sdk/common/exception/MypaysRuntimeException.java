package com.zoeyun.mypays.sdk.common.exception;

public class MypaysRuntimeException extends RuntimeException{

    public MypaysRuntimeException(Throwable e) {
        super(e);
    }

    public MypaysRuntimeException(String msg) {
        super(msg);
    }

    public MypaysRuntimeException(String msg, Throwable e) {
        super(msg, e);
    }
}
