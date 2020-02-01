package com.wenyu7980.basic.common.dictionary;

/**
 * 系统字典Enum接口
 * 字典分为以下两种
 * 系统字典：参与业务逻辑，不可以随意设置，所以需要硬编码，
 *           修改时，伴随着业务逻辑的修改
 * 用户字典：不参与业务逻辑，可以由用户随意设置，不需要硬编码
 * @author wenyu
 * @date 2020-01-31 
 */
public interface DictionaryEnum {
    /**
     * 字典名称
     * @return
     */
    default String dictName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 字典code
     * @return
     */
    String dictCode();

    /**
     * 字典项
     * @return
     */
    DictionaryEnum[] items();

    /**
     * 字典项名称
     * @return
     */
    String name();

    /**
     * 字典项code
     * @return
     */
    String code();
}
