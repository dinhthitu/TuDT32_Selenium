package base;

import org.testng.annotations.*;
import utils.Calculator;

public class BaseTest {

    protected Calculator calculator;
    @BeforeClass
    public void setUp(){
        System.out.println("Before class");
    }

    @BeforeMethod
    public void initTestCase(){
        System.out.println("Start Test Case");
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class");
    }

    @AfterMethod
    public void cleanTestCase(){
        System.out.println("End Test Case");
        calculator = null;
    }
}
