package com.wenyu7980.basic.common.jpaconverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.AttributeConverter;
import java.lang.reflect.Type;

/**
 *
 * @author wenyu
 * @date 2020-04-29 
 */
public class AbstractAttributeConverter<T>
        implements AttributeConverter<T, String> {
    private static Gson GSON = new GsonBuilder().create();
    private Type clazz;

    public AbstractAttributeConverter(Type clazz) {
        this.clazz = clazz;
    }

    @Override
    public String convertToDatabaseColumn(T attribute) {
        return GSON.toJson(attribute);
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        return GSON.fromJson(dbData, clazz);
    }
}
