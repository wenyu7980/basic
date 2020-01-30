package com.wenyu7980.basic.config.json;

import com.google.gson.*;
import com.wenyu7980.basic.config.json.adapter.LocalDateAdapter;
import com.wenyu7980.basic.config.json.adapter.LocalDateTimeAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-01-29 
 */
@Configuration
public class GsonWebConfig implements WebMvcConfigurer {
    private final Gson GSON;

    public GsonWebConfig() {
        this.GSON = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
                new LocalDateTimeAdapter())
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                /** 处理Swagger UI页面异常 */
                .registerTypeAdapter(Json.class, new JsonSerializer<Json>() {
                    @Override
                    public JsonElement serialize(Json src, Type typeOfSrc,
                            JsonSerializationContext context) {
                        return JsonParser.parseString(src.value());
                    }
                }).create();
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        converters.add(new GsonHttpMessageConverter(this.GSON));
    }
}
