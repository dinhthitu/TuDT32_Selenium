package locators;

import org.openqa.selenium.By;

public class TestLocators {

    public static final By startBtn
            = By.xpath("//div[@id='start']/child::button");

    public static final By loadingStatus
            = By.xpath("//div[@id='loading']/img");

    public static final By successMessage
            = By.xpath("//h4[text()='Hello World!']");
}
