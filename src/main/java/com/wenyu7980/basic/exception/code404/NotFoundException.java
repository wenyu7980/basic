package com.wenyu7980.basic.exception.code404;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * 不存在异常
 * @author wenyu
 * @date 2020-01-26 
 */
public class NotFoundException extends AbstractException {
    public NotFoundException(String message, Object... params) {
        super(HttpStatus.NOT_FOUND, 1, message, params);
    }
}
