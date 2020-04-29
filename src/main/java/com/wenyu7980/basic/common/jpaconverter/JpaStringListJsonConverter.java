package com.wenyu7980.basic.common.jpaconverter;

import com.google.gson.reflect.TypeToken;

import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-04-29 
 */
@Converter(autoApply = true)
public class JpaStringListJsonConverter
        extends AbstractAttributeConverter<List<String>> {
    public JpaStringListJsonConverter() {
        super(new TypeToken<ArrayList<String>>() {
        }.getType());
    }
}
