package com.wenyu7980.basic.exception.code403;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * 权限不足
 * @author wenyu
 * @date 2020-01-28 
 */
public class InsufficientException extends AbstractException {

    public InsufficientException(String message, Object... params) {
        super(HttpStatus.FORBIDDEN, message, params);
    }
}
