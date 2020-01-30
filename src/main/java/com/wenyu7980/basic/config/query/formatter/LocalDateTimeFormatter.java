package com.wenyu7980.basic.config.query.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author wenyu
 * @date 2020-01-29 
 */
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    /** 日期格式器 */
    private static final DateTimeFormatter FORMAT = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public LocalDateTime parse(String text, Locale locale)
            throws ParseException {
        return LocalDateTime.parse(text, FORMAT);
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return object.format(FORMAT);
    }
}
