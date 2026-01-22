
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CalculatorTest extends BaseTest {

    @Test(groups = "smoke")
    public void shouldAddTwoNumbers() {
        int addResult = calculator.add(2, 3);
        Assert.assertEquals(addResult, 5, "Addition result is incorrect");
    }

    @Test(groups = "smoke")
    public void shouldSubtractTwoNumbers() {
        int result = calculator.subtract(10, 4);
        Assert.assertEquals(result, 6, "Subtraction result is incorrect");
    }

    @Test(groups = "regression")
    public void shouldMultiplyTwoNumbers() {
        int result = calculator.multiply(3, 5);
        Assert.assertEquals(result, 15, "Multiplication result is incorrect");
    }

    @Test(groups = "regression")
    public void shouldDivideTwoNumbers() {
        int result = calculator.divide(20, 4);
        Assert.assertEquals(result, 5, "Division result is incorrect");
    }

    @Test(groups = {"regression", "edge"})
    public void shouldValidateMultipleOperationsUsingSoftAssert() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(calculator.add(1, 1), 2, "Add failed");
        softAssert.assertEquals(calculator.subtract(5, 2), 3, "Subtract failed");
        softAssert.assertEquals(calculator.multiply(2, 3), 6, "Multiply failed");

        softAssert.assertAll();
    }

    @Test(groups = "edge")
    public void shouldThrowExceptionWhenDivideByZero() {
        Assert.assertThrows(
                "Expected exception when dividing by zero",
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
        );
    }
}
