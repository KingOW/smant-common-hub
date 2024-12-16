package com.smant.common.core.enums;

import lombok.Getter;

/**
 * 字典数据类型
 */
@Getter
public enum DictDataCategory {
    DATA_TYPE_LONG(1,"整型类型"),
    DATA_TYPE_DOUBLE(2,"小数类型"),
    DATA_TYPE_NUMBER(3,"数字类型"),
    DATA_TYPE_DATE(4,"时间类型"),
    DATA_TYPE_TEXT(5,"文本/字符串类型"),

    ;
    private  final int  code;
    private final String name;

    DictDataCategory(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final DictDataCategory[] ALL_VALUES = DictDataCategory.values();

    public static DictDataCategory DictDataCategoryByCode(int code) {
        for (DictDataCategory dataCategory : ALL_VALUES) {
            if (dataCategory.code == code) return dataCategory;
        }
        return DATA_TYPE_LONG;
    }
}
