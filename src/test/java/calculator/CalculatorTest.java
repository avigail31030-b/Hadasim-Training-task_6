package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{
	@Test
	void addTwoNumber()
	{
		Calculator calc = new Calculator();
    	assertEquals(3, calc.calculate("1+2"));
	}	

	@Test
	void MultipliesTwoNumbers()
	{
		Calculator calc = new Calculator();
		assertEquals(6, calc.calculate("2*3"));
	}

	@Test
	void divisionTwoNumbers()
	{
		Calculator calc = new Calculator();
		assertEquals(2, calc.calculate("6/3"));
	}

	@Test
	void respectsOperatorPrecedence()
	{
		Calculator calc = new Calculator();
		assertEquals(-8.2, calc.calculate("-1+-2*3.6"));
	}
}