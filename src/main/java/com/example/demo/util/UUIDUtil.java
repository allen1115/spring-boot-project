package com.example.demo.util;

import java.util.UUID;

public class UUIDUtil {

    /**
     * get specific number of uuid
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
     * get one uuid
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
