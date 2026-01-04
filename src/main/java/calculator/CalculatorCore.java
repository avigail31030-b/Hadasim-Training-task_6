package calculator;

public class CalculatorCore 
{
    private final Calculator cal = new Calculator();
    private final Validation vd = new Validation();
    
    public double calculateCore(String input)
    {
        String cleanInput = vd.removeWhiteSpave(input);
        vd.Vlidate(cleanInput);
        return cal.calculate(cleanInput);
    }
}
