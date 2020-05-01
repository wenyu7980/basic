package com.wenyu7980.basic.exception.code409;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * 不一致异常
 * @author wenyu
 * @date 2020-02-12 
 */
public class InconsistentException extends AbstractException {
    public InconsistentException(String message, Object... params) {
        super(HttpStatus.CONFLICT, message, params);
    }
}
