import base.BaseTest;
import driver.DriverManager;
import locators.TestLocators;

import org.testng.annotations.Test;
import pages.DynamicLoading;
import utils.CustomWaitFunc;

import static org.testng.Assert.assertEquals;

public class TestWaitStrategies extends BaseTest {

    private DynamicLoading dynamicLoading;

    @Test(priority = 1)
    public void testSuccessMessage(){

        dynamicLoading = new DynamicLoading(DriverManager.getDriver(), 10);

        dynamicLoading.clickStartBtn();
        dynamicLoading.waitForLoadingDisappear();
        String successMessage = dynamicLoading.getSuccessMessage();

        assertEquals("Hello World!", successMessage);
    }


    // advance
    @Test (priority = 2)
    public void testAdvance(){

        CustomWaitFunc waitFunc = new CustomWaitFunc(DriverManager.getDriver(), 10);

        DriverManager.getDriver().findElement(TestLocators.startBtn).click();

        waitFunc.waitForLoadingDisappear(TestLocators.loadingStatus);

        waitFunc.waitForText(TestLocators.successMessage);

        assertEquals("Hello World!", DriverManager.getDriver().findElement(TestLocators.successMessage).getText());

    }


}
