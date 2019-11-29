package com.cmb.jwt.exception;

/**
 * @Author gaozhao
 * @创建时间 2019/11/28
 * @描述
 **/
public class TokenIsExpiredException extends Exception{

    public TokenIsExpiredException() {
    }

    public TokenIsExpiredException(String message) {
        super(message);
    }

    public TokenIsExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenIsExpiredException(Throwable cause) {
        super(cause);
    }

    public TokenIsExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
