package steps;

import io.qameta.allure.Step;
import com.selenium.at.core.keywords.WebUI;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

import static pages.InventoryPage.*;

public class InventoryPageSteps extends WebUI {
    @Step("Click add to cart")
    public InventoryPageSteps addRandomItem(){
        List<WebElement> ADDCARTBTN = driver.findElements(ADD_BTN);
        int maxProducts = ADDCARTBTN.size();
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        ADDCARTBTN.get(randomProduct).click();
        waitUntilTextChange(ADD_BTN,driver.findElement(RMV_BTN).getText().toString());
        return this;
    }
    @Step("Check remove button is {0}")
    public InventoryPageSteps validateRemoveButton(int button){
        List<WebElement> RMVBTN = driver.findElements(RMV_BTN);
        Assert.assertTrue(RMVBTN.size() == button, "Remove button is " + RMVBTN.size() + " and not equals with " + button);
        return this;
    }

    @Step("Check cart count is {0}")
    public InventoryPageSteps validateCartCount(int count){
        WebElement COUNTCART = driver.findElement(COUNT_CART);
        Assert.assertTrue(COUNTCART.getText().equals(Integer.toString(count)), "Remove button is " + COUNTCART.getText() + " and not equals with " + count);
        return this;
    }

    @Step("Click Cart Button")
    public InventoryPageSteps clickCartButton(){
        clickElement(CART_BTN);
        containsCurrentURL("/cart.html");
        return this;
    }

}
