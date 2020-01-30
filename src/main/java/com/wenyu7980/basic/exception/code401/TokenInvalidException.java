package com.wenyu7980.basic.exception.code401;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * token失效
 * @author wenyu
 * @date 2020-01-28 
 */
public class TokenInvalidException extends AbstractException {
    public TokenInvalidException(String message, Object... params) {
        super(HttpStatus.UNAUTHORIZED, 2, message, params);
    }
}
