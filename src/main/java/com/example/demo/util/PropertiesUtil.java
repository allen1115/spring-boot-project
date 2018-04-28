package com.example.demo.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {
    private final ResourceBundle resource;
    private final String fileName;

    /**
     * Initialize
     * @param fileName
     */
    public PropertiesUtil( String fileName) {
        this.fileName = fileName;
        Locale locale = new Locale("zh", "CN");
        this.resource = ResourceBundle.getBundle(this.fileName, locale);
    }

    /**
     * get value from key
     * @param key
     * @return
     */
    public String getValue(String key) {
        String message = this.resource.getString(key);
        return message;
    }
}
