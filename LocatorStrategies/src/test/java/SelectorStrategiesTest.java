import base.BaseTest;
import config.configData;
import driver.DriverManager;
import locators.LocatorItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorStrategiesTest extends BaseTest{


    @Test(priority = 1)
    public void testByID() {
   
            WebElement textBoxMenu = DriverManager.getDriver().findElement(LocatorItems.TEXT_BOX_MENU);
            textBoxMenu.click();
            
            WebElement fullName = DriverManager.getDriver().findElement(LocatorItems.PERMANENT_ADDRESS);
            fullName.sendKeys(configData.username);

            test.pass("Locator By ID - SUCCESS");

    }

    @Test(priority = 2)
    public void testByClassName() {

            WebElement element = DriverManager.getDriver().findElement(LocatorItems.ELEMENT_DROPDOWN);
            element.click();
            element.click();

            test.pass("Locator By ClassName - SUCCESS");

    }

    @Test(priority = 3)
    public void testByCSSSelector() {

            DriverManager.getDriver().findElement(LocatorItems.TEXT_BOX_MENU).click();

            WebElement userNameByCSS = DriverManager.getDriver().findElement(LocatorItems.USERNAME);
            userNameByCSS.clear();
            userNameByCSS.sendKeys("CSS Test");

            test.pass("CSS Selector - SUCCESS");

    }

    @Test(priority = 4)
    public void testByXPathRelative() {

            DriverManager.getDriver().findElement(LocatorItems.WEB_TABLES).click();
            test.pass("XPath Relative - SUCCESS");

    }

    @Test(priority = 5)
    public void testByChained(){

            DriverManager.getDriver().findElement(LocatorItems.UP_DOWN).click();

            By byChained = new ByChained(LocatorItems.UPLOAD_FILE);

            DriverManager.getDriver().findElement(byChained)
                    .sendKeys(configData.fileTest);

            test.pass("ByChained - SUCCESS");

    }

    @Test(priority = 6)
    public void testByLinkText() throws InterruptedException {

        DriverManager.getDriver().findElement(LocatorItems.BROKEN_LINKS).click();
        Thread.sleep(2000);
        DriverManager.getDriver().findElement(LocatorItems.VALID_LINK).click();

        DriverManager.getDriver().navigate().back();

            test.pass("LinkText - SUCCESS");

    }

    @Test(priority = 7)
    public void testByPartialLinkText() throws InterruptedException {


            DriverManager.getDriver().findElement(LocatorItems.BROKEN_LINKS).click();
            Thread.sleep(2000);
            DriverManager.getDriver().findElement(LocatorItems.INVALID_LINK).click();

            DriverManager.getDriver().navigate().back();

            test.pass("PartialLinkText - SUCCESS");

    }

    @Test(priority = 8)
    public void testByTagName() {

            List<WebElement> allLinks = DriverManager.getDriver().findElements(LocatorItems.ALL_LINKS);
            test.info("Total <a> tags: " + allLinks.size());

            test.pass("TagName - SUCCESS");

    }

    @Test(priority = 9)
    public void testByXPath2(){
        DriverManager.getDriver().findElement(LocatorItems.TEXT_BOX_MENU).click();
        DriverManager.getDriver().findElement(LocatorItems.CURRENT_ADDRESS).sendKeys(configData.username);

        test.pass("Test by xpath relationship - success");
    }

    @Test(priority = 10)
    public void testByXPath3(){
        DriverManager.getDriver().findElement(LocatorItems.TEXT_BOX_MENU).click();
        DriverManager.getDriver().findElement(LocatorItems.FULL_NAME).sendKeys(configData.username);

        test.pass("Test by xpath fullname - success");
    }


    @Test(priority = 11)
    public void testAdvancedXPathFunctions(){

            DriverManager.getDriver().findElement(LocatorItems.TEXT_BOX_MENU).click();
            DriverManager.getDriver().findElement(LocatorItems.xPathContain);
            DriverManager.getDriver().findElement(LocatorItems.xPathByText);
            DriverManager.getDriver().findElement(LocatorItems.xPathByID);
            DriverManager.getDriver().findElement(LocatorItems.xPathStartWith);

            test.pass("Advanced XPath - SUCCESS");

    }

}
