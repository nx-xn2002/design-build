package com.nx.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static String SETTING_PATH = "config.properties";
    public static String getPropertyByName(String name) {
        String property = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(SETTING_PATH));
            property = properties.getProperty(name);
        } catch (IOException e) {
            System.out.println("无效配置:" + name);
        }
        return property;
    }
}
