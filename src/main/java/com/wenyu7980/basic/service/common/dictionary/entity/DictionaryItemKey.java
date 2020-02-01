package com.wenyu7980.basic.service.common.dictionary.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wenyu
 * @date 2020-01-31 
 */
@Embeddable
public class DictionaryItemKey implements Serializable {
    /** 字典code */
    private String dictCode;
    /** 字典项code */
    private String code;

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        DictionaryItemKey that = (DictionaryItemKey) object;
        return Objects.equals(dictCode, that.dictCode) && Objects
                .equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictCode, code);
    }
}
