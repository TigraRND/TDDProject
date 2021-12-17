import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(testName = "Тест на суммирование")
    public void sumTest() {
        double arg1 = 3.6;
        double arg2 = 10.0;
        double expected = 13.6;
        double actual = calculator.sum(arg1,arg2);

        Assert.assertEquals(actual,expected);
    }

    @Test(testName = "Тест на вычитание")
    public void subtractionTest() {
        double arg1 = 30.0;
        double arg2 = 9.0;
        double expected = 21.0;
        double actual = calculator.subtraction(arg1,arg2);

        Assert.assertEquals(actual,expected);
    }

    @Test(testName = "Тест на умножение")
    public void multiplyTest() {
        double arg1 = 8.0;
        double arg2 = 3.0;
        double expected = 24.0;
        double actual = calculator.multiply(arg1,arg2);

        Assert.assertEquals(actual,expected);
    }

    @Test(testName = "Тест на деление")
    public void divisionTest() {
        double arg1 = 20.0;
        double arg2 = 8.0;
        double expected = 2.5;
        double actual = calculator.division(arg1,arg2);

        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
