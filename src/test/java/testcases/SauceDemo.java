package testcases;

import com.google.gson.Gson;
import jdk.jfr.Description;
import model.User;
import steps.CartPageSteps;
import steps.CheckoutPageSteps;
import steps.InventoryPageSteps;
import steps.LoginPageSteps;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.selenium.at.constant.Constants.URL;

public class SauceDemo extends BaseTest {
    LoginPageSteps loginPageSteps;
    InventoryPageSteps inventoryPageSteps;
    CartPageSteps cartPageSteps;
    CheckoutPageSteps checkoutPageSteps;
    @DataProvider(name = "UserJsonFile")
    public Object[][] getUserJsonFile(){
        Gson gson = new Gson();
        try{
            User[] user = gson.fromJson(new FileReader("src/main/resources/data.json"), User[].class);
            Object[][] data = new Object[user.length][1];
            for (int i = 0; i < user.length; i++) {
                data[i][0] = user[i];
            }
            return data;
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
    @Test(dataProvider = "UserJsonFile", groups ={"group 1"}, description = "Test Login")
    @Description("To test the login site")
    public void loginTest(User user){
        loginPageSteps = new LoginPageSteps();
        loginPageSteps.goToUrl(URL).verifyTitle();
        loginPageSteps.loginWithCredentials(user.getUserName(),user.getPassword());
    }
    @Test(dataProvider = "UserJsonFile", groups ={"group 1"})
    public void buyTest(User user){
        loginPageSteps = new LoginPageSteps();
        loginPageSteps.goToUrl(URL)
                .verifyTitle()
                .loginWithCredentials(user.getUserName(),user.getPassword());
        inventoryPageSteps = new InventoryPageSteps();
        inventoryPageSteps.addRandomItem()
                .validateRemoveButton(1)
                .validateCartCount(1)
                .addRandomItem()
                .validateRemoveButton(2)
                .validateCartCount(2)
                .clickCartButton();
        cartPageSteps = new CartPageSteps();
        cartPageSteps.validateCartAdded(2)
                .clickCheckoutButton();
        checkoutPageSteps = new CheckoutPageSteps();
        checkoutPageSteps.validateUrlCheckoutStep1()
                .inputUserInfo(user.getFirstName(),user.getLastName(),user.getZipCode())
                .validateUrlCheckoutStep2()
                .clickFinishBTN()
                .validateUrlCheckoutComplete()
                .clickBACKHOMEBTN()
                .validateUrlInventory();
    }
}
