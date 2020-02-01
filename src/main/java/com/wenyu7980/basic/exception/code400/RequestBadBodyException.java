package com.wenyu7980.basic.exception.code400;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * 请求数据错误
 * @author wenyu
 * @date 2020-02-01 
 */
public class RequestBadBodyException extends AbstractException {
    public RequestBadBodyException(String message, Object... params) {
        super(HttpStatus.BAD_REQUEST, 1, message, params);
    }
}
