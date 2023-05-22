package pages;

import org.openqa.selenium.By;

public class InventoryPage {
    public static By ADD_BTN = By.xpath("//button[contains(text(),'Add to cart')]");

    public static By RMV_BTN = By.xpath("//button[contains(text(),'Remove')]");
    public static By COUNT_CART = By.xpath("//span[@class='shopping_cart_badge']");
    public static By CART_BTN = By.xpath("//a[@class='shopping_cart_link']");
}
