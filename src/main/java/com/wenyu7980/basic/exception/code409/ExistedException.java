package com.wenyu7980.basic.exception.code409;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * 已存在异常
 * @author wenyu
 * @date 2020-02-01 
 */
public class ExistedException extends AbstractException {
    public ExistedException(String message, Object... params) {
        super(HttpStatus.CONFLICT, 1, message, params);
    }
}
