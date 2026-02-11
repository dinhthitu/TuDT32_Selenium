package base.MouseActions;

import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    private static int index = 1;

    @BeforeMethod
    public void initBrowser() {
        DriverManager.initDriver();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        takeScreenshot();
        DriverManager.quitDriver();
    }

    private void takeScreenshot() throws IOException {
        TakesScreenshot scrShot = (TakesScreenshot) DriverManager.getDriver();
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File targetedFile = new File("./screenshots/image" + index + ".png");
        index++;
        targetedFile.getParentFile().mkdirs();
        FileUtils.copyFile(srcFile, targetedFile);
    }
}