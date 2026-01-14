import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;

public class S1_Homework1 {

    WebDriver driver;
    @BeforeAll
    public static void setup() throws IOException {
        configProperties.initializeProperty();
    }

    @Test
    public void Setup_success() throws InterruptedException {
        //set up browser
        if(configProperties.browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(configProperties.url);
        WebElement searchBox = driver.findElement(By.className("gLFyf"));;
        searchBox.sendKeys("maven");
        searchBox.sendKeys(Keys.ENTER);
        // navigate back
        Thread.sleep(2000);
        driver.navigate().back();
        // sleep
        Thread.sleep(1000);

        driver.quit();

    }
}