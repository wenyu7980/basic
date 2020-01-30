package com.wenyu7980.basic.config.json.adapter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日期转换
 * @author wenyu
 * @date 2020-01-29 
 */
public class LocalDateAdapter
        implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    /** 日期格式器 */
    private static final DateTimeFormatter FORMAT = DateTimeFormatter
            .ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), FORMAT);
    }

    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc,
            JsonSerializationContext context) {
        return new JsonPrimitive(src.format(FORMAT));
    }
}
