package com.smant.common.core.enums;

import lombok.Getter;

/**
 * 字典分类类型
 */
@Getter
public enum DictTypeCategory {
    DICT_TYPE_LONG(1, "整型数字字典", DictDataCategory.DATA_TYPE_LONG),
    DICT_TYPE_DOUBLE(2, "小数数据字典", DictDataCategory.DATA_TYPE_DOUBLE),
    DICT_TYPE_NUMBER(3, "数字数据字典", DictDataCategory.DATA_TYPE_NUMBER),
    DICT_TYPE_DATE(4, "时间数据字典", DictDataCategory.DATA_TYPE_DATE),
    DICT_TYPE_TEXT(5, "文本/字符串数据字典", DictDataCategory.DATA_TYPE_TEXT),
    DICT_TYPE_INTERVAL_INT(21, "区间数据字典(整型数字类型数据)", DictDataCategory.DATA_TYPE_LONG),
    DICT_TYPE_INTERVAL_DOUBLE(22, "区间数据字典(小数数字类型数据)", DictDataCategory.DATA_TYPE_DOUBLE),
    DICT_TYPE_INTERVAL_NUMBER(23, "区间数据字典(数字类型数据)", DictDataCategory.DATA_TYPE_NUMBER),
    DICT_TYPE_INTERVAL_DATE(24, "区间数据字典(时间类型数据)", DictDataCategory.DATA_TYPE_DATE),
    DICT_TYPE_INTERVAL_TEXT(25, "区间数据字典(文本/字符串数据)", DictDataCategory.DATA_TYPE_TEXT),
    ;

    private final int code;
    private final String name;
    private final DictDataCategory dataCategory;

    DictTypeCategory(int code, String name, DictDataCategory dataCategory) {
        this.code = code;
        this.name = name;
        this.dataCategory = dataCategory;
    }

    private static final DictTypeCategory[] ALL_VALUES = DictTypeCategory.values();

    public static DictTypeCategory DictTypeCategoryByCode(int code) {
        for (DictTypeCategory typeCategory : ALL_VALUES) {
            if (typeCategory.code == code) return typeCategory;
        }
        return DICT_TYPE_TEXT;
    }
}
