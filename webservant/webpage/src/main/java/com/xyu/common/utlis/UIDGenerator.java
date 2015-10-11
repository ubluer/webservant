package com.xyu.common.utlis;

import java.util.UUID;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/11
 * UIDGenerator 用于生成各类唯一id
 */
public class UIDGenerator {
    /**
     * 生成不带-的uuid
     * @return uuid
     */
    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.replace("-","");
        return temp;
    }

    /**
     * 生成带‘-‘的uuid
     * @return uuid
     */
    public static String generateUUIDWithBar(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
