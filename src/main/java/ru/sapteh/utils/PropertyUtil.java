package ru.sapteh.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public String getProperties(String key) {
        String propertyValue = "";
        Properties properties = new Properties();

        try(FileReader reader = new FileReader("./src/main/resources/data_sourse.properties")) {
            properties.load(reader);
            propertyValue = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }
}
