package com.wenyu7980.basic.common.jpaconverter;

import com.google.gson.reflect.TypeToken;

import javax.persistence.Converter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-04-29 
 */
@Converter(autoApply = true)
public class JpaStringSetJsonConverter
        extends AbstractAttributeConverter<Set<String>> {
    public JpaStringSetJsonConverter() {
        super(new TypeToken<HashSet<String>>() {
        }.getType());
    }
}
