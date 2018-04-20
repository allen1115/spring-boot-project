package com.example.demo.util;

import java.util.UUID;

public class UUIDUtil {

    /**
     * 获取指定数量的uuid
     * @param number uuid的数量
     * @return
     */
    public static String[] getUUID(int number) {
        if(number < 1) {
            return null;
        }
        String[] retArray = new String[number];
        for (int i = 0; i < number; i++) {
            retArray[i] = getUUID();
        }
        return retArray;
    }

    /**
     * 获得一个UUID
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
