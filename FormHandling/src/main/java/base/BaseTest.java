package base;

import driver.DriverManage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void initBrowser() {
        DriverManage.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManage.quitDriver();
    }
}
