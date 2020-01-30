package com.wenyu7980.basic.exception;

import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
public abstract class AbstractException extends RuntimeException {
    private HttpStatus status;
    private Integer code;

    public AbstractException(HttpStatus status, Integer code, String message,
            Object... params) {
        super(MessageFormat.format(message, params));
        this.status = status;
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }
}
