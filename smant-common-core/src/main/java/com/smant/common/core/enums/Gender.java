package com.smant.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别
 */
@Getter
@AllArgsConstructor
public enum Gender {

    UNKNOWN(1, "未知", "未知"),
    MEN(2, "男", "男"),
    WOMEN(3, "女", "女"),

    ;
    private final int code;
    private final String name;
    private final String desc;


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
}
