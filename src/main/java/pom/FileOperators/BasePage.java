package pom.FileOperators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    protected Actions action;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public WebElement waitForVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(By element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(By locator) {
        WebElement element = getElement(locator);
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );
    }

    public void click(By locator) {
        scrollToElement(locator);
        WebElement element = waitForClickable(locator);
        element.click();
    }

    public void sendKeys(By locator, String text) {
        scrollToElement(locator);
        WebElement element = getElement(locator);
        waitForVisible(element);
        element.clear();
        element.sendKeys(text);
    }


}
