package pages;

import org.openqa.selenium.By;

public class CheckoutPage {
    public static By FNAME_FIELD = By.xpath("//input[@id='first-name']");
    public static By LNAME_FIELD = By.xpath("//input[@id='last-name']");
    public static By ZIP_FIELD = By.xpath("//input[@id='postal-code']");
    public static By CONTINUE_BTN = By.xpath("//input[@type='submit']");
    public static By FINISH_BTN = By.xpath("//button[@id='finish']");
    public static By BACKHOME_BTN = By.xpath("//button[contains(text(),'Back Home')]");

}
