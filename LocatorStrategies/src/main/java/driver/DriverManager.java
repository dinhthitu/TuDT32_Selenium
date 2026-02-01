package driver;

import config.configData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;

public class DriverManager {

    private static WebDriver driver;

<<<<<<<< HEAD:Exercise2.3/src/main/java/driver/DriverManager.java
    public static void initDriver() {
========
>>>>>>>> f0d3836d63c763d2f5d743e3d6b91b615bbe0aaa:LocatorStrategies/src/main/java/driver/DriverManager.java

    public static void initDriver() throws IOException{
        configData.initializeProperty();

        if (configData.browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get(configData.url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }

    }

}
