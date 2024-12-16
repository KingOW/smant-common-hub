package com.smant.common.core.utils;

/**
 * 字符串工具类
 */
public final class StringExtUtils {

    /**
     * 是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断字符串去掉两边空格后是否为空
     * @param str
     * @return
     */
    public static boolean isTrimEmpty(String str){
        return str == null || str.trim().length() == 0;
    }
    /**
     * 去掉空格
     *
     * @param str
     * @return
     */
    public static String trimStr(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return str.trim();
    }

    public static void main(String[] args) {
        String str = null;
        System.out.println( str == null || str.trim().length() == 0);
    }
    /**
     *
     * @param source
     * @param target
     * @return
     */
    public static boolean equalsStr(String source, String target) {
        return trimStr(source).equals(trimStr(target));
    }
}
