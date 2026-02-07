package pages;

import config.PageUrls;
import locators.PageLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage navigateTo() {
        driver.get(PageUrls.TEXTBOX.getUrl());
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        WebElement currentAddressField = waitUntilClickable(PageLocators.CURRENT_ADDRESS);
        action.click(currentAddressField)
                .sendKeys(address)
                .perform();
        return this;
    }

    public TextBoxPage deleteCurrentAddress() {
        WebElement currentAddressField = driver.findElement(PageLocators.CURRENT_ADDRESS);
        action.click(currentAddressField)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        return this;
    }

    public String getCurrentAddress() {
        WebElement currentAddress = driver.findElement(PageLocators.CURRENT_ADDRESS);
        return currentAddress.getAttribute("value");
    }
}