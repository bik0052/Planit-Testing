package com.planit.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties props = new Properties();

    public ConfigReader() {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public String getBaseUrl() { return props.getProperty("baseUrl").trim(); }
    public String getBrowser() { return props.getProperty("browser", "chrome").trim(); }
    public boolean isHeadless() { return Boolean.parseBoolean(props.getProperty("headless", "true").trim()); }
    public long getPageLoadTimeout() { return Long.parseLong(props.getProperty("pageLoadTimeout","45").trim()); }
    public long getImplicitWait() { return Long.parseLong(props.getProperty("implicitWait","0").trim()); }
    public long getExplicitWait() { return Long.parseLong(props.getProperty("explicitWait","20").trim()); }
}
