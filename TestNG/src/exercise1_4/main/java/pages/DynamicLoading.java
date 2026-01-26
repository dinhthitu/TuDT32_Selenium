package pages;
import locators.TestLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicLoading {
    private WebDriver driver;
    private WebDriverWait wait;

    public DynamicLoading(WebDriver driver, int timeout){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public void clickStartBtn(){
        driver.findElement(TestLocators.startBtn).click();
    }

    public void waitForLoadingDisappear(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(TestLocators.loadingStatus));
    }

    public String getSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TestLocators.successMessage)).getText();
    }
}