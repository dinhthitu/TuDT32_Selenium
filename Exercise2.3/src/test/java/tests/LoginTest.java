package tests;

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
    }

    @Test(priority = 1)
    public void test_login_successfully(){

        loginPage.openLoginPage();

        successPage = loginPage
                .enterUsername(ConfigData.username)
                .enterPassword(ConfigData.password)
                .clickSubmit();

        assertTrue(successPage.isLoggedIn());
        assertEquals(ConfigData.successUrl, successPage.getSuccessURL());
        assertEquals(ConfigData.message, successPage.getSuccessText());

    }

    @Test(priority = 2)
    public void test_login_invalid_username(){

        loginPage.openLoginPage();
        loginPage
                .enterUsername(ConfigData.invalidUsername)
                .enterPassword(ConfigData.password)
                .clickSubmit();

        assertEquals("Your username is invalid!", loginPage.getErrorMessage());

    }

    @Test(priority = 3)
    public void test_login_invalid_password(){

        loginPage.openLoginPage();
        loginPage
                .enterUsername(ConfigData.username)
                .enterPassword(ConfigData.invalidPassword)
                .clickSubmit();
        assertEquals("Your password is invalid!", loginPage.getErrorMessage());
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
