package com.wenyu7980.basic.exception.code401;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
public class LoginFailException extends AbstractException {
    public LoginFailException(String message, Object... params) {
        super(HttpStatus.UNAUTHORIZED, 3, message, params);
    }
}
