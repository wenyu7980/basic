package com.wenyu7980.basic.config.json.adapter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间转换
 * @author wenyu
 * @date 2020-01-29 
 */
public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>,
        JsonDeserializer<LocalDateTime> {
    /** 日期格式器 */
    private static final DateTimeFormatter FORMAT = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        return LocalDateTime
                .parse(json.getAsJsonPrimitive().getAsString(), FORMAT);
    }

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc,
            JsonSerializationContext context) {
        return new JsonPrimitive(src.format(FORMAT));
    }
}
