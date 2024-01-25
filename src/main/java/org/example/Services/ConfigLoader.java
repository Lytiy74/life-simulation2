package org.example.Services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static final String configPath;
    private static final Properties CONFIG_PROPERTIES = new Properties();
    static {
        configPath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+
                "config.properties";
        try {
            CONFIG_PROPERTIES.load(new FileInputStream(configPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return CONFIG_PROPERTIES.getProperty(key);
    }
    public static int getIntProperty(String key){
        return Integer.parseInt(CONFIG_PROPERTIES.getProperty(key));
    }
    public static double getDoubleProperty(String key){
        return Double.parseDouble(CONFIG_PROPERTIES.getProperty(key));
    }
}
