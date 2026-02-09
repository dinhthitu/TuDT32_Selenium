import base.BaseTest;
import config.ConfigProperties;
import driver.DriverManager;
import locators.PageLocators;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ButtonPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class ButtonTest extends BaseTest {

    private ButtonPage buttonPage;

    @BeforeMethod
    public void setup() {
        buttonPage = new ButtonPage(DriverManager.getDriver()).navigateTo();
    }

    @Test
    public void testDoubleClickSuccess() {
        String message = buttonPage
                .doubleClickButton(PageLocators.DOUBLE_CLICK_BTN)
                .getDoubleClickMsg();

        assertEquals(message, ConfigProperties.doubleClickMsg);
    }

    @Test
    public void testDoubleClickUnsuccessful() {
        buttonPage.moveToButtonAndClick(PageLocators.DOUBLE_CLICK_BTN);
        assertFalse(buttonPage.isDoubleClickMessageDisplayed());
    }

    @Test
    public void testRightClickSuccess() {
        String message = buttonPage
                .rightClickButton(PageLocators.RIGHT_CLICK_BTN)
                .getRightClickMsg();

        assertEquals(message, ConfigProperties.rightClickMsg);
    }

    @Test
    public void testRightClickUnsuccessful() {
        buttonPage.doubleClickButton(PageLocators.RIGHT_CLICK_BTN);
        assertFalse(buttonPage.isRightClickMessageDisplayed());
    }

    @Test
    public void testMoveAndClickSuccess() {
        String message = buttonPage
                .moveToButtonAndClick(PageLocators.CLICK_BTN)
                .getClickMsg();

        assertEquals(message, ConfigProperties.clickMsg);
    }
}