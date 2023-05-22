package testcases;

import com.selenium.at.core.drivers.DriverManager;
import com.selenium.at.report.AllureManager;
import com.selenium.at.utils.TestListener;
import org.testng.annotations.*;

import static com.selenium.at.constant.Constants.URL;

@Listeners({TestListener.class})
public class BaseTest {
    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browserName) throws Exception{
        DriverManager.openBrowser(browserName);
        AllureManager.setAllureEnvironmentInformation(URL, browserName, "Moi Truong Nop Bai");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){ DriverManager.quitDriver(); }
}
