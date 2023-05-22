package com.selenium.at.report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import com.selenium.at.core.drivers.DriverManager;
import org.openqa.selenium.TakesScreenshot;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static org.openqa.selenium.OutputType.BYTES;
public class AllureManager {
    public AllureManager(){}
    public static void setAllureEnvironmentInformation(String url , String browser, String env){
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder().put("url", url)
            .put("browser", browser)
            .put("env", env)
            .put("device", "pc").build()
            , System.getProperty("user.dir") + "/allure-results/");
    }


    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport(){
        try{
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
        } catch (Exception e){
            e.getMessage();
        }
        return new byte[0];
    }

    @Attachment(value ="{0}" , type="text/plain")
    public static String saveTextLog(String message){ return message;}
}
