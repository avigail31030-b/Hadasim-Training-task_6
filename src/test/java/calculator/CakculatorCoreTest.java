package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CakculatorCoreTest 
{
    @Test
    void removesWhitespaceBeforeCalculation()
    {
        CalculatorCore core = new CalculatorCore();
        double result = core.calculateCore("1 + 2 ");
        assertEquals(3, result);
    }
}
