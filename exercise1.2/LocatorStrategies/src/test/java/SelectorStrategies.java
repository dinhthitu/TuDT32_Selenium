import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import config.configProperties;
import config.configReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SelectorStrategies {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void init() throws IOException, InterruptedException {
        extent = configReport.getReport();
        configProperties.initializeProperty();

        if (configProperties.browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get(configProperties.url);
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void testByID() {
        test = extent.createTest("TC01 - Locator By ID");

        try {
            WebElement textBoxMenu = driver.findElement(By.id("item-0"));
            textBoxMenu.click();
//            test.info("Click TextBox menu");

            WebElement fullName = driver.findElement(By.id("userName"));
            fullName.sendKeys(configProperties.username);
//            test.info("Input Full Name");

            test.pass("Locator By ID - SUCCESS");
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }

    @Test(priority = 2)
    public void testByClassName() {
        test = extent.createTest("TC02 - Locator By ClassName");

        try {
            WebElement element = driver.findElement(By.className("pr-1"));
            element.click();
            element.click();

            test.pass("Locator By ClassName - SUCCESS");
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }

    @Test(priority = 3)
    public void testByCSSSelector() {
        test = extent.createTest("TC03 - Locator By CSS Selector");

        try {
            driver.findElement(By.id("item-0")).click();

            WebElement userNameByCSS = driver.findElement(By.cssSelector("#userName"));
            userNameByCSS.clear();
            userNameByCSS.sendKeys("CSS Test");

            test.pass("CSS Selector - SUCCESS");
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }

    @Test(priority = 4)
    public void testByXPathRelative() {
        test = extent.createTest("TC04 - Locator By XPath Relative");

        try {
            driver.findElement(By.xpath("//li[@id='item-3']")).click();
            test.pass("XPath Relative - SUCCESS");
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }

    @Test(priority = 5)
    public void testByXPathAbsolute() throws InterruptedException {
        test = extent.createTest("TC05 - Locator By ByChained");

        try {
            driver.findElement(By.id("item-7")).click();

            By byChained = new ByChained(By.className("form-file"), By.id("uploadFile"));

            driver.findElement(byChained)
                    .sendKeys("E:\\Auto\\LocatorStrategies\\config.properties");

            test.pass("ByChained - SUCCESS");
            Thread.sleep(500);
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }

    @Test(priority = 6)
    public void testByLinkText() {
        test = extent.createTest("TC06 - Locator By LinkText");

        try {
            driver.findElement(By.id("item-6")).click();
            driver.findElement(By.linkText("Click Here for Valid Link")).click();

            driver.navigate().back();

            test.pass("LinkText - SUCCESS");
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }

    @Test(priority = 7)
    public void testByPartialLinkText() {
        test = extent.createTest("TC07 - Locator By PartialLinkText");

        try {
            driver.findElement(By.id("item-6")).click();
            driver.findElement(By.partialLinkText("Click Here")).click();

            driver.navigate().back();

            test.pass("PartialLinkText - SUCCESS");
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }

    @Test(priority = 8)
    public void testByTagName() {
        test = extent.createTest("TC08 - Locator By TagName");

        try {
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            test.info("Total <a> tags: " + allLinks.size());

            test.pass("TagName - SUCCESS");
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }

    @Test(priority = 9)
    public void testByIdAgain() {
        test = extent.createTest("TC09 - Locator By ID (item-2)");

        try {
            driver.findElement(By.id("item-2")).click();
            test.pass("Locator By ID (item-2) - SUCCESS");
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }

    @Test(priority = 10)
    public void testCssLocator2 () throws InterruptedException {
        test = extent.createTest("TC10 - Test CSSLocator 2");
        try{
            driver.findElement(By.id("item-8")).click();
            driver.findElement(By.cssSelector(".mt-4")).click();
            test.pass("Locator By CSS - SUCCESS");
        }catch(Exception e){
            test.fail(e);
            throw e;
        }

        Thread.sleep(3000);

    }
    @Test(priority = 11)
    public void testAdvancedXPathFunctions() throws InterruptedException {
        test = extent.createTest("TC10 - Advanced XPath Functions");

        try {
            driver.findElement(By.id("item-0")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[contains(@placeholder,'Full')]"));
            driver.findElement(By.xpath("//input[starts-with(@id,'user')]"));
            driver.findElement(By.xpath("//input[@type='text' and @id='userName']"));
            driver.findElement(By.xpath("//input[@id='userName' or @id='userEmail']"));
            driver.findElement(By.xpath("//input[@id='userName']/parent::div"));

            test.pass("Advanced XPath - SUCCESS");
        } catch (Exception e) {
            test.fail(e);
            throw e;
        }
    }



    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(2000);
            driver.quit();
        }
        extent.flush();
        System.out.println("Report generated: reports/LocatorStrategies.html");
    }
}
