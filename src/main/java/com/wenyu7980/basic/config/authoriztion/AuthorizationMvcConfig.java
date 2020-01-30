package com.wenyu7980.basic.config.authoriztion;

import com.wenyu7980.basic.authorization.interceptor.AuthInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
@Configuration
public class AuthorizationMvcConfig implements WebMvcConfigurer {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AuthorizationMvcConfig.class);

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                // 排除swarger
                .excludePathPatterns("/swagger**", "/v2/api-docs",
                        "/swagger-resources/**", "/webjars/**")
                .excludePathPatterns("/error");
        LOGGER.info("权限配置");
    }
}
