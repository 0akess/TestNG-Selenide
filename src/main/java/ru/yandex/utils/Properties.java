package ru.yandex.utils;

import java.io.IOException;
import java.io.InputStream;

public class Properties {

    public static String loadProperty(String propertyName) {

        java.util.Properties prop = new java.util.Properties();
        String property = "";
        String env = System.getProperty("env");

        try {
            InputStream resourceAsStream = ClassLoader.getSystemResourceAsStream(env + ".properties");
            prop.load(resourceAsStream);
            property = prop.getProperty(propertyName);
            return property;
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + propertyName);
            return property;
        }
    }
}
