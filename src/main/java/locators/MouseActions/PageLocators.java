package locators.MouseActions;

import org.openqa.selenium.By;

public class PageLocators {

    // Button Page
    public static final By DOUBLE_CLICK_BTN = By.id("doubleClickBtn");
    public static final By RIGHT_CLICK_BTN = By.id("rightClickBtn");
    public static final By CLICK_BTN = By.xpath("//button[text()='Click Me']");
    public static final By DOUBLE_BTN_MSG = By.id("doubleClickMessage");
    public static final By RIGHT_CLICK_MSG = By.id("rightClickMessage");
    public static final By CLICK_MSG = By.id("dynamicClickMessage");

    // Droppable Page
    public static final By INTERACTIONS_ELEMENT = By.xpath("//div[text()='Interactions']");
    public static final By DROPPABLE = By.xpath("//span[text()='Droppable']");
    public static final By DRAG_ME = By.id("draggable");
    public static final By DROP_HERE = By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']");
    public static final By DROPPED = By.xpath("//div[@id='droppable']/p[text()='Dropped!']");

    // TextBox Page
    public static final By CURRENT_ADDRESS = By.id("currentAddress");
}