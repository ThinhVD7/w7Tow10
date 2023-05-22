package com.selenium.at.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureUtils {
    static String projectPath = System.getProperty("user.dir");
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
    public static void captureScreen(WebDriver driver, String name){
        PropertiesFile.setPropertiesFile();
        String screenShotPath = projectPath + "/" + PropertiesFile.getPropValue("captureFolder");
        Log4j.info(screenShotPath);
        try{
            File dir = new File(screenShotPath);
            if(!dir.exists()){
                dir.mkdir();
            }
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(screenShotPath + "/" + name +"_" + sdf.format(new Date()) + ".png");
            FileUtils.copyFile(src,dest);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
