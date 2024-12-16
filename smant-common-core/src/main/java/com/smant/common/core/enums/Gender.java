package com.smant.common.core.enums;


/**
 * 性别
 */
public enum Gender {

    UNKNOWN(1, "未知", "未知"),
    MEN(2, "男", "男"),
    WOMEN(3, "女", "女"),

    ;
    private final int code;
    private final String name;
    private final String desc;

    Gender(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    private static final Gender[] ALL_VALUES = Gender.values();

    /**
     * 根据编码 获取性别
     * @param code
     * @return
     */
    public static Gender SexByCode(int code) {
        for (Gender gender : ALL_VALUES) {
            if (gender.code == code) {
                return gender;
            }
        }
        return UNKNOWN;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
