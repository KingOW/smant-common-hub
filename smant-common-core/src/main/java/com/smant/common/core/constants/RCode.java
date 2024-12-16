package com.smant.common.core.constants;

import com.smant.common.core.enums.DefRCode;

/**
 * 运行结果编码
 */
public interface RCode {

    default int getCode(){
        return DefRCode.SUCCESS.getCode();
    };

    default String getMsg(){
        return DefRCode.SUCCESS.getMsg();
    }
}
