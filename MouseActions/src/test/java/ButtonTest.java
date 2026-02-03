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
    public void setup(){
        buttonPage = new ButtonPage(DriverManager.getDriver());
    }

    @Test
    public void double_click_success() {
        String message = buttonPage
                .doubleClickButton(PageLocators.DOUBLE_CLICK_BTN)
                .getDoubleClickMsg();

        assertEquals(ConfigProperties.doubleClickMsg,message);
    }

    @Test
    public void double_click_unsuccess() {
        buttonPage = buttonPage.moveToButtonAndClick(PageLocators.DOUBLE_CLICK_BTN);
        assertFalse(buttonPage.isDoubleClickMessageDisplayed());
    }

    @Test
    public void right_click_success() {
            String message = buttonPage
                    .rightClickButton(PageLocators.RIGHT_CLICK_BTN)
                    .getRightClickMsg();
            assertEquals(ConfigProperties.rightClickMsg, message);
    }

    @Test
    public void right_click_unsuccess() {
        buttonPage = buttonPage.doubleClickButton(PageLocators.RIGHT_CLICK_BTN);
        assertFalse(buttonPage.isRightClickMessageDisplayed());
    }


    @Test
    public void move_and_click_success() {
        String message = buttonPage
                .moveToButtonAndClick(PageLocators.CLICK_BTN)
                .getClickMsg();
        assertEquals(ConfigProperties.clickMsg, message);
    }
}
