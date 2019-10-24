
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
public class CalculatorTests {
    Calculator calculator = new Calculator();
    public int value1 = 1;
    public int value2 = 1;
    public int correctResult = 2;
    public int incorrectResult = 3;

    @Test
    public void firstTest() {
        int result = calculator.add(value1,value2);
        assertTrue(correctResult == result);
    }

    @Test
    public void secondTest() {
        int result = calculator.add(value1,value2);
        assertFalse(incorrectResult == result);
    }

    @Test
    public void thirdTest() {
        int result = calculator.add(value1,value2);
        assertEquals(result, correctResult);
    }



}
