package com.wenyu7980.basic.config.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *
 * @author wenyu
 * @date 2020-03-01 
 */
//@RestControllerAdvice
public class ResponseBodyPackageAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
            MediaType mediaType, Class aClass,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {
        if (serverHttpRequest.getURI().getPath().contains("swagger")
                || serverHttpRequest.getURI().getPath().contains("api-docs")) {
            return o;
        }
        return new ResponsePackageBody(200, o);
    }
}
