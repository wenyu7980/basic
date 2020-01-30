package com.wenyu7980.basic.exception.config;

import com.wenyu7980.basic.exception.AbstractException;
import com.wenyu7980.basic.exception.code500.SystemException;
import com.wenyu7980.basic.exception.domain.ErrorMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 异常处理
 * @author wenyu
 * @date 2020-01-28 
 */
@RestControllerAdvice
public class ExceptionHandlerConfiguration {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ExceptionHandlerConfiguration.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMsg> handler(Exception e) {
        if (e instanceof AbstractException) {
            AbstractException exception = (AbstractException) e;
            if (exception instanceof SystemException) {
                LOGGER.error("开发异常", e);
            } else {
                LOGGER.debug("异常", e);
            }
            return new ResponseEntity(
                    new ErrorMsg(exception.getCode(), exception.getMessage()),
                    exception.getStatus());
        }
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult result = ((MethodArgumentNotValidException) e)
                    .getBindingResult();
            String message = result.getFieldErrors().stream().map(error -> {
                return error.getField() + error.getDefaultMessage() + ",值:"
                        + error.getRejectedValue();
            }).collect(Collectors.joining(","));
            return new ResponseEntity(new ErrorMsg(9, message),
                    HttpStatus.BAD_REQUEST);
        }
        LOGGER.error("系统错误", e);
        return new ResponseEntity<ErrorMsg>(new ErrorMsg(9, e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
