package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest
{
    @Test
    void ignoreWhiteSpaceInExpression()
    {
        Validation vd = new Validation();
        String result = vd.removeWhiteSpave("1 + 2 + 1");
        assertEquals("1+2+1", result);
    }

    @Test
    void throwExceptionOnDivisionByZero()
    {
        Validation vd = new Validation();
        assertThrows(ArithmeticException.class, () -> {
            vd.Vlidate("8/0");});
    }
}

