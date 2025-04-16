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

    /**
     * 默认 十位数字
     */
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static String randomStr(int length){
        if(length == CommConstants.NUMBER_0){
            length = CommConstants.NUMBER_10;
        }
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(index));
        }
        return randomString.toString();
    }
    /***
     * 长度为10 的字符串
     * @return
     */
    public static String randomStr10(){
        // 生成一个随机字符串
        return randomStr(CommConstants.NUMBER_10);
    }

    /**
     * 长度为6 的字符串
     * @return
     */
    public static String randomStr6(){
        // 生成一个随机字符串
        return randomStr(CommConstants.NUMBER_6);
    }
    /**
     * 长度为8 的字符串
     * @return
     */
    public static String randomStr8(){
        // 生成一个随机字符串
        return randomStr(CommConstants.NUMBER_8);
    }
}
