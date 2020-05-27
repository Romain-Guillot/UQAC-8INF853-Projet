package com.uqac.stablemanager.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

    private static Properties properties;

    private ApplicationProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Properties getProperties() {
        if (properties == null)
            new ApplicationProperties();
        return properties;
    }
}
