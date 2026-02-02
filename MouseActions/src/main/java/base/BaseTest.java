package base;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    static int index = 1;
    @BeforeMethod
    public void initBrowser() {
        DriverManager.initDriver();
    }

    @AfterMethod
    public void teaDown() throws IOException {
        TakesScreenshot scrShot = (TakesScreenshot) DriverManager.getDriver();
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File targetedFile = new File("./image" + index + ".png");
        index++;
        FileUtils.copyFile(srcFile, targetedFile);
        DriverManager.quitDriver();
    }

}
