package com.smant.common.core.enums;


/**
 * 分类
 */
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

    AddressCategory(String code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
