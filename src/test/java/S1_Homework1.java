import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class S1_Homework1 {

    WebDriver driver;
    @BeforeClass
    public static void setup() throws IOException {
        configProperties.initializeProperty();
    }

    @Test
    public void firstTest() throws InterruptedException {
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