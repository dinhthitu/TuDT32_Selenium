package pages;

import locators.LoginLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoginPage(){

        wait.until(ExpectedConditions.elementToBeClickable(LoginLocators.PRACTICE_PAGE)).click();

        wait.until(ExpectedConditions.elementToBeClickable(LoginLocators.TEST_LOGIN_PAGE)).click();

    }

    public void login(String username, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.USERNAME))
                .sendKeys(username);

        driver.findElement(LoginLocators.PASSWORD).sendKeys(password);
        driver.findElement(LoginLocators.SUBMIT).click();

    }

    public String getSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.LOGIN_SUCCESS)).getText();
    }

}
