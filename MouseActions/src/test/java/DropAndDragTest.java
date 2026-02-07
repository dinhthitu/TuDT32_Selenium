import base.BaseTest;
import driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DroppablePage;

import static org.testng.Assert.assertEquals;

public class DropAndDragTest extends BaseTest {

    private DroppablePage droppablePage;

    @BeforeMethod
    public void setup() {
        droppablePage = new DroppablePage(DriverManager.getDriver()).navigateTo();
    }

    @Test
    public void testDragAndDrop() {
        String message = droppablePage
                .dragAndDrop()
                .getDroppedMessage();

        assertEquals(message, "Dropped!");
    }
}