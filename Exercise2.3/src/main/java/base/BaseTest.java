package base;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

    @BeforeMethod
    public void setUp() throws IOException {
        DriverManager.initDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
