package ru.job4j.dreamjob.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesConfig {

    private volatile static PropertiesConfig config = null;
    private final Properties properties = new Properties();

    private PropertiesConfig() throws IOException {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(in);
        }
    }

    public static PropertiesConfig getConfig() throws IOException {
        if (config == null) {
            synchronized (PropertiesConfig.class) {
                if (config == null) {
                    config = new PropertiesConfig();
                }
            }
        }
        return config;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
