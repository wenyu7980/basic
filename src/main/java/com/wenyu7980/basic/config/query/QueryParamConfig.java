package com.wenyu7980.basic.config.query;

import com.wenyu7980.basic.config.query.formatter.LocalDateFormatter;
import com.wenyu7980.basic.config.query.formatter.LocalDateTimeFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author wenyu
 * @date 2020-01-29 
 */
@Configuration
public class QueryParamConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDateTime.class,
                new LocalDateTimeFormatter());
        registry.addFormatterForFieldType(LocalDate.class,
                new LocalDateFormatter());
    }
}

