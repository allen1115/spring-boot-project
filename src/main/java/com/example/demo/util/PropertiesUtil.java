package com.example.demo.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {
    private final ResourceBundle resource;
    private final String fileName;

    /**
     * 构造函数实例化部分对象, 获取文件资源对象
     * @param fileName
     */
    public PropertiesUtil( String fileName) {
        this.fileName = fileName;
        Locale locale = new Locale("zh", "CN");
        this.resource = ResourceBundle.getBundle(this.fileName, locale);
    }

    /**
     * 根据传入的key获取对象的值
     * @param key
     * @return
     */
    public String getValue(String key) {
        String message = this.resource.getString(key);
        return message;
    }
}
