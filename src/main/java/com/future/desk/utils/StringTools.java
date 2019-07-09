package com.future.desk.utils;

/**
 * @author: stone
 * @create: 2019-07-04 13:42
 * 字符串工具类
 **/
public class StringTools {

    /**
     * 为空
     * @return
     */
    public static boolean isNull(String str){
        if(str == null || "".equals(str.trim())){
            return true;
        }else
            return false;
    }

}

    
