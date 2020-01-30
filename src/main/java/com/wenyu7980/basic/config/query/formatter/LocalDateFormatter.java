package com.wenyu7980.basic.config.query.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author wenyu
 * @date 2020-01-29 
 */
public class LocalDateFormatter implements Formatter<LocalDate> {
    /** 日期格式器 */
    private static final DateTimeFormatter FORMAT = DateTimeFormatter
            .ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text.substring(0, 10), FORMAT);
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return object.format(FORMAT);
    }
}
