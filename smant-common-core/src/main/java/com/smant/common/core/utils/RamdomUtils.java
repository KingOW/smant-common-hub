package com.smant.common.core.utils;

import com.smant.common.core.constants.CommConstants;

import java.util.Random;

/**
 * 随机数
 */
public final class RamdomUtils {
    /***
     * 10以内的随机整数
     * @return
     */
    public static int randomInt10(){
        // 生成一个随机整数
        return randomInt(CommConstants.NUMBER_10);
    }

    /**
     * 100以内的随机整数
     * @return
     */
    public static int randomInt100(){
        // 生成一个随机整数
        return randomInt(CommConstants.NUMBER_100);
    }

    public static int randomInt(int bound){
        if(bound == CommConstants.NUMBER_0){
            bound = CommConstants.NUMBER_10;
        }
        // 创建一个Random类的实例
        Random random = new Random();
        // 生成一个随机整数
        return random.nextInt(bound);
    }
}
