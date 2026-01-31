package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(id = "error")
    private WebElement errorMsg;

    @FindBy(xpath = "//a[contains(normalize-space(), 'Practice')]")
    private WebElement practicePage;

    @FindBy(linkText = "Test Login Page")
    private WebElement loginPageSection;

    public String getErrorMessage() {
        waitUntilVisible(errorMsg);
        return errorMsg.getText();
    }

    public LoginPage enterUsername(String input) {
        waitUntilVisible(username);
        username.clear();
        username.sendKeys(input);
        return this;
    }

    public LoginPage enterPassword(String input) {
        password.clear();
        password.sendKeys(input);
        return this;
    }

    public SuccessPage clickSubmit() {
        waitUntilClickable(submit);
        submit.click();
        return new SuccessPage(driver);
    }


    public void openLoginPage() {
        waitUntilClickable(practicePage);
        practicePage.click();

        waitUntilClickable(loginPageSection);
        loginPageSection.click();
    }


}
