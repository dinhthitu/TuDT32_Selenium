package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage{

    public SuccessPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Logged In Successfully']")
    private WebElement successMessage;

    public String getSuccessText(){
        return successMessage.getText();
    }

    public boolean isLoggedIn(){
        return successMessage.isDisplayed();
    }
}
