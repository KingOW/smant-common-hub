package com.smant.common.core.utils;

import java.util.UUID;

public final class UUIDUtils {

    /**
     * 生成随机UUID
     * @return
     */
    public static String randomUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
