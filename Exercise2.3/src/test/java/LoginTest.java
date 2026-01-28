import base.BaseTest;
import config.ConfigData;
import driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SuccessPage;
import utils.WindowUtils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private SuccessPage successPage;

    @BeforeMethod
    public void initPage(){
        loginPage = new LoginPage(DriverManager.getDriver());
        successPage = new SuccessPage(DriverManager.getDriver());
    }

    @Test(priority = 1)
    public void test_login_successfully(){

        loginPage.openLoginPage();
        loginPage.login(ConfigData.username, ConfigData.password);

        assertTrue(successPage.isLoggedIn());
        assertEquals(ConfigData.message, successPage.getSuccessText());

    }

    @Test(priority = 2)
    public void test_login_invalid_username(){

        loginPage.openLoginPage();
        loginPage.login(ConfigData.invalidUsername, ConfigData.password);

        assertEquals("Your username is invalid!", loginPage.getErrorMessage());

    }


    @Test(priority = 3)
    public void test_login_invalid_password(){

        loginPage.openLoginPage();
        loginPage.login(ConfigData.username, ConfigData.invalidPassword);

        assertEquals("Your password is invalid!", loginPage.getErrorMessage());
    }

    @Test
    public void test_debug(){
        System.out.println("DEBUG RUN");
    }


    @Test(priority = 4)
    public void test_advanced_requirements()  {

        loginPage.openLoginPage();

        String mainTab = WindowUtils.openNewTab(DriverManager.getDriver());
        WindowUtils.closeAllTabs(DriverManager.getDriver(), mainTab);
        WindowUtils.refreshCurrentTab(DriverManager.getDriver());

        assertEquals(DriverManager.getDriver().getWindowHandle(), mainTab);

    }
}
