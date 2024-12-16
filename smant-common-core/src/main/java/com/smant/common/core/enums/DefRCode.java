package com.smant.common.core.enums;

import com.smant.common.core.constants.RCode;
import lombok.Getter;

@Getter
public enum DefRCode implements RCode {

    SUCCESS(200,"操作成功","操作成功"),
    FAIL(500,"操作失败","操作失败"),


    ;

    private final int code;
    private final String name;
    private final String msg;

    DefRCode(int code, String name, String msg) {
        this.code = code;
        this.name = name;
        this.msg = msg;
    }
    ;
}
