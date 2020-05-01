package com.wenyu7980.basic.exception.code401;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * 未登录
 * @author wenyu
 * @date 2020-01-28 
 */
public class NoLoginException extends AbstractException {
    public NoLoginException(String message, Object... params) {
        super(HttpStatus.UNAUTHORIZED, message, params);
    }
}
