package pom.MouseActions;

import config.PageUrls;
import locators.MouseActions.PageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public DroppablePage navigateTo() {
        driver.get(PageUrls.DROPPABLE.getUrl());
        return this;
    }

    public DroppablePage dragAndDrop() {
        WebElement dragElement = waitUntilVisible(PageLocators.DRAG_ME);
        WebElement dropElement = waitUntilVisible(PageLocators.DROP_HERE);

        action.dragAndDrop(dragElement, dropElement).perform();
        return this;
    }

    public String getDroppedMessage() {
        WebElement message = waitUntilVisible(PageLocators.DROPPED);
        return message.getText();
    }
}