package com.wenyu7980.basic.exception.code400;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * 检索项目异常瓬
 * @author wenyu
 * @date 2020-02-05 
 */
public class SearchBodyBadException extends AbstractException {
    public SearchBodyBadException(String message, Object... params) {
        super(HttpStatus.BAD_REQUEST, 1, message, params);
    }
}
