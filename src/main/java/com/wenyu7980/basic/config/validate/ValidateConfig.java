package com.wenyu7980.basic.config.validate;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 校验
 * @author wenyu
 * @date 2020-01-29 
 */
@Configuration
public class ValidateConfig {
    @Bean
    public Validator validator() {
        ValidatorFactory factory = Validation
                .byProvider(HibernateValidator.class).configure().failFast(true)
                .buildValidatorFactory();
        return factory.getValidator();
    }
}
