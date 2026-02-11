package pom.MouseActions;

import config.PageUrls;
import locators.MouseActions.PageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ButtonPage extends BasePage {

    public ButtonPage(WebDriver driver) {
        super(driver);
    }

    public ButtonPage navigateTo() {
        driver.get(PageUrls.BUTTON.getUrl());
        return this;
    }

    public ButtonPage doubleClickButton(By locator) {
        WebElement doubleClick = waitUntilClickable(locator);
        action.doubleClick(doubleClick).perform();
        return this;
    }

    public String getDoubleClickMsg() {
        WebElement doubleMsg = waitUntilVisible(PageLocators.DOUBLE_BTN_MSG);
        return doubleMsg.getText();
    }

    public ButtonPage rightClickButton(By locator) {
        WebElement rightClick = waitUntilClickable(locator);
        action.contextClick(rightClick).perform();
        return this;
    }

    public String getRightClickMsg() {
        WebElement rightClickMsg = waitUntilVisible(PageLocators.RIGHT_CLICK_MSG);
        return rightClickMsg.getText();
    }

    public ButtonPage moveToButtonAndClick(By locator) {
        WebElement clickBtn = waitUntilClickable(locator);
        action.moveToElement(clickBtn)
                .pause(Duration.ofMillis(200))
                .click()
                .perform();
        return this;
    }

    public String getClickMsg() {
        WebElement clickMsg = waitUntilVisible(PageLocators.CLICK_MSG);
        return clickMsg.getText();
    }

    public boolean isDoubleClickMessageDisplayed() {
        return driver.findElements(PageLocators.DOUBLE_BTN_MSG).size() > 0;
    }

    public boolean isRightClickMessageDisplayed() {
        return driver.findElements(PageLocators.RIGHT_CLICK_MSG).size() > 0;
    }
}