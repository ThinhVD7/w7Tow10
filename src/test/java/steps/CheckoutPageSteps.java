package steps;

import io.qameta.allure.Step;
import com.selenium.at.core.keywords.WebUI;

import static pages.CheckoutPage.*;


public class CheckoutPageSteps  extends WebUI {
    @Step("Validate url contains /checkout-step-one.html")
    public CheckoutPageSteps validateUrlCheckoutStep1(){
        containsCurrentURL("/checkout-step-one.html");
        return this;
    }
    @Step("Input user info")
    public CheckoutPageSteps inputUserInfo(String fn, String ln, String zip){
        sendKeys(FNAME_FIELD, fn);
        sendKeys(LNAME_FIELD, ln);
        sendKeys(ZIP_FIELD, zip);
        clickElement(CONTINUE_BTN);
        return this;
    }

    @Step("Validate url contains /checkout-step-two.html")
    public CheckoutPageSteps validateUrlCheckoutStep2(){
        containsCurrentURL("/checkout-step-two.html");
        return this;
    }

    @Step("Click Finish")
    public CheckoutPageSteps clickFinishBTN(){
        clickElement(FINISH_BTN);
        return this;
    }

    @Step("Validate url contains /checkout-complete.html")
    public CheckoutPageSteps validateUrlCheckoutComplete(){
        containsCurrentURL("/checkout-complete.html");
        return this;
    }

    @Step("Click Finish")
    public CheckoutPageSteps clickBACKHOMEBTN(){
        clickElement(BACKHOME_BTN);
        return this;
    }

    @Step("Validate url contains /inventory.html")
    public CheckoutPageSteps validateUrlInventory(){
        containsCurrentURL("/inventory.html");
        return this;
    }
}
