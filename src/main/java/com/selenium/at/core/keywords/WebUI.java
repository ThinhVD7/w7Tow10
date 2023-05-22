package com.selenium.at.core.keywords;

import com.selenium.at.core.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.selenium.at.constant.Constants.WAIT_TIME;

public class WebUI {
    public WebDriver driver;
    WebDriverWait wait;
    public WebUI(){
        try {
            driver = DriverManager.getDriver();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    protected void visitWebsite(String url){
        driver.get(url);
    }
    protected void waitForElementIsClickable(By by){
        try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable error){
            System.err.println(error.getMessage());
        }
    }
    protected void clickElement(By by){
        waitForElementIsClickable(by);
        driver.findElement(by).click();;
    }
    protected void clearValue(By by){
        clickElement(by);
        driver.findElement(by).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.DELETE);
    }
    protected void sendKeys(By by, String value){
        clickElement(by);
        clearValue(by);
        driver.findElement(by).sendKeys(value);
    }
    protected List<WebElement> getListElements (By by){
        return driver.findElements(by);
    }

    protected boolean elementIsPresent(By by){
        try{
            driver.findElement(by);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    protected By replaceValueInXpath(String oldXpath, String oldVal, String newVal){
        return By.xpath(oldXpath.replace(oldVal, newVal));
    }
    protected String getTextElement(By by){
        return driver.findElement(by).getText();
    }
    protected void sleep(long time){
        try{
            Thread.sleep(time * 1000);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    protected void containsCurrentURL(String url){
        Assert.assertTrue(driver.getCurrentUrl().contains(url), "Current url is \"" + driver.getCurrentUrl() +"\" and not contains \"" + url + "\"" );
    }
    protected void waitUntilTextChange(By by , String text){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by,text));
    }
}
