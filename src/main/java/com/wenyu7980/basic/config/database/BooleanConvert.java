package com.wenyu7980.basic.config.database;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * boolean类型转换
 * @author wenyu
 * @date 2020-01-28 
 */
@Converter(autoApply = true)
public class BooleanConvert implements AttributeConverter<Boolean, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) {
            return null;
        }
        if (attribute) {
            return 1;
        }
        return 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        if (dbData.equals(0)) {
            return false;
        }
        return true;
    }
}
