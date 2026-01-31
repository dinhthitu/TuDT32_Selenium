package base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import report.ReportManager;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

// handle PR requirement
public class BaseTest {
    /**
     * Base Test
     * 1. Setup webdriver
     * 2. Teardown webdriver
     *
     */
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setUp() throws IOException{
        DriverManager.initDriver();
        DriverManager.getDriver();
        extent = ReportManager.getReport();
        test = extent.createTest("Test Case");
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        DriverManager.quitDriver();
        extent.flush();
    }



}
