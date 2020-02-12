package com.wenyu7980.basic.authorization.annotation;

import com.wenyu7980.basic.authorization.constant.TokenType;

import java.lang.annotation.*;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthRequest {

    /**
     * 是否需要登录
     * 缺省是需要token
     * @return
     */
    boolean required() default true;

    /**
     * 是否需要权限校验
     * @return
     */
    boolean check() default true;

    /**
     * 需要token时，token的类型
     * @return
     */
    TokenType type() default TokenType.HEADER;
}
