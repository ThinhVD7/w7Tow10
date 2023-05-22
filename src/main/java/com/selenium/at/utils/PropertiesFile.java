package com.selenium.at.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFile {
    private static Properties properties;
    static String projectPath = System.getProperty("user.dir");
    static String propertiesFilePath = "src/test/resources/config.properties";
    static String fullPathPropertiesFile = projectPath + "/" + propertiesFilePath;
    public static void setPropertiesFile(){
        properties = new Properties();
        try{
            FileInputStream fileIn = new FileInputStream(fullPathPropertiesFile);
            properties.load(fileIn);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static String getPropValue(String KeyProp) {
        String value = null;
        try {
            value = properties.getProperty(KeyProp);
            System.out.println(value);
            return value;
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return value;
    }
    public static void setPropValue(String KeyProp, String Value) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fullPathPropertiesFile);
            properties.setProperty(KeyProp, Value);
            properties.store(fileOut, "Set new value in properties file");
            System.out.println("Set new value in file properties success.");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

}
