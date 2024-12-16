package com.smant.common.core.enums;


public enum DatePattern {
    YYYY_MM_DD("YYYY-MM-DD"),
    YYYY_MM_DD_2("YYYYMMMDD"),
    YYYY_MM_DD_HH("YYYY-MM-DD-HH"),
    YYYY_MM_DD_HH_2("YYYYMMDDHH"),

    YY_MM_DD("YY-MM-DD"),
    YY_MM_DD_2("YYMMDD"),

    ;

    private final String value;
    DatePattern(String value){
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
