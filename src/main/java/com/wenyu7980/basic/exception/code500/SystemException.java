package com.wenyu7980.basic.exception.code500;

import com.wenyu7980.basic.exception.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * 系统开发错误
 * @author wenyu
 * @date 2020-01-28 
 */
public class SystemException extends AbstractException {
    public SystemException(String message, Object... params) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, 1, message, params);
    }
}
