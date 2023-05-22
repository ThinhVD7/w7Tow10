package pages;

import org.openqa.selenium.By;

public class LoginPage {
    public static By USERNAME_FIELD = By.id("user-name");
    public static By PASSWORD_FIELD = By.id("password");
    public static By LOGIN_BTN = By.xpath("//input[@type='submit']");
}
