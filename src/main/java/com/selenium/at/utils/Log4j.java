package com.selenium.at.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log4j {
    private static final Logger log = LogManager.getLogger(Log4j.class);
    public static void info(String message){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");
        String timestamp = sdf.format(date);
        message = String.format("INFO: [%s] %s", timestamp, message);
        System.out.println("--> "+ message);
    }
    public static void warn(String message) { log.warn(message);}
    public static void error(String message){ log.error(message);}


}
