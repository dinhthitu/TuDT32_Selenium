import base.BaseTest;
import config.ConfigData;
import driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.WindowUtils;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void initPage(){
        loginPage = new LoginPage(DriverManager.getDriver());
    }
    @Test(priority = 1)
    public void test_login_successfully(){

        loginPage.openLoginPage();
        loginPage.login(ConfigData.username, ConfigData.password);
        assertEquals(ConfigData.message, loginPage.getSuccessMessage());
    }

    @Test(priority = 2)
    public void test_advanced_requirements()  {

        loginPage.openLoginPage();
        String mainTab = WindowUtils.openNewTab(DriverManager.getDriver());
        WindowUtils.closeAllTabs(DriverManager.getDriver(), mainTab);
        WindowUtils.refreshCurrentTab(DriverManager.getDriver());
        assertEquals(DriverManager.getDriver().getWindowHandle(), mainTab);

    }
}
