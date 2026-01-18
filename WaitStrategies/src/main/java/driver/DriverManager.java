package driver;

import config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    private static WebDriver driver;

    public static void initDriver() {

        if(ConfigProperties.browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }  else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(ConfigProperties.url);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
