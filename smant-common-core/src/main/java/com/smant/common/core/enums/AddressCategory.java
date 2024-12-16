package com.smant.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 分类
 */
@AllArgsConstructor
@Getter
public enum AddressCategory {
    NATION("N", "国家", "国家"),
    PROVINCE("P", "省", "省"),
    CITY("C", "市", "市"),
    AREA("A", "区","区"),
    TOWN("T","乡镇","乡镇"),
    VILLAGE("V","村","村"),
    STREET("S","街道","街道"),

    ;
    private final String code;
    private final String name;
    private final String desc;
}
