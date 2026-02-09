import base.BaseTest;
import config.ConfigProperties;
import driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TextBoxPage;

import static org.testng.Assert.assertEquals;

public class TextBoxTest extends BaseTest {

    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void setup() {
        textBoxPage = new TextBoxPage(DriverManager.getDriver()).navigateTo();
    }

    @Test
    public void testSetCurrentAddress() {
        String currentAddress = textBoxPage
                .setCurrentAddress(ConfigProperties.currentAddress)
                .deleteCurrentAddress()
                .setCurrentAddress(ConfigProperties.currentAddress)
                .getCurrentAddress();

        assertEquals(currentAddress, ConfigProperties.currentAddress);
    }
}