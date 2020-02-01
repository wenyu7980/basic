package com.wenyu7980.basic.service.common.dictionary.entity;

import javax.persistence.*;

/**
 *
 * @author wenyu
 * @date 2020-01-31 
 */
@Table(name = "sys_dict_item")
@Entity
public class DictionaryItemEntity {
    @EmbeddedId
    private DictionaryItemKey key = new DictionaryItemKey();
    /** 项目名 */
    private String name;
    /** 字段类型 */
    @ManyToOne
    @MapsId("dictCode")
    private DictionaryEntity dict;

    private DictionaryItemEntity() {
    }

    public DictionaryItemEntity(DictionaryEntity dictionary, String code,
            String name) {
        this.dict = dictionary;
        this.key.setCode(code);
        this.name = name;
    }

    public String getCode() {
        return this.key.getCode();
    }

    public String getName() {
        return name;
    }
}
