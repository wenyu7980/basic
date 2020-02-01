package com.wenyu7980.basic.service.common.dictionary.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-01-31 
 */
@Table(name = "sys_dict")
@Entity
public class DictionaryEntity {
    /** 字典code */
    @Id
    private String code;
    /** 字典名 */
    private String name;
    /** 是否是系统字典 */
    private Boolean systemFlag = false;
    /** 备注 */
    private String remark;
    /** 字典项 */
    @OneToMany(mappedBy = "dict", cascade = CascadeType.ALL)
    private List<DictionaryItemEntity> items = new ArrayList<>();

    private DictionaryEntity() {
    }

    public DictionaryEntity(String code, String name, Boolean systemFlag,
            String remark) {
        this.code = code;
        this.name = name;
        this.systemFlag = systemFlag;
        this.remark = remark;
    }

    public void addItem(DictionaryItemEntity item) {
        this.items.add(item);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }

    public List<DictionaryItemEntity> getItems() {
        return items;
    }
}
