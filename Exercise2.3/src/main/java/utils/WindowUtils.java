package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class WindowUtils {

    private WindowUtils() { };

    public static String openNewTab(WebDriver driver) {
        String currentTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        return currentTab;
    }

    public static void closeAllTabs(WebDriver driver, String mainTab) {
        for (String tab: driver.getWindowHandles()) {
            if (!tab.equals(mainTab)) {
                driver.switchTo().window(tab);
                driver.close();
            }
        }
        driver.switchTo().window(mainTab);
    }

    public static void refreshCurrentTab(WebDriver driver) {
        driver.navigate().refresh();
    }
}
