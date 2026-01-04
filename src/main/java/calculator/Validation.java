package calculator;

public class Validation {

    public String removeWhiteSpave(String input)
    {
        return input.replaceAll("\\s+", "");
    }

    public void Vlidate(String input)
    {
        if(input.contains("/0"))
        {
            throw new ArithmeticException("Division by zero");
        }
    }
    
}
