package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator
{
    public double calculate(String expression)
    {
        if (expression == null || expression.isEmpty())
        {
            throw new IllegalArgumentException("Expression is empty");
        }

        Deque<Double> values = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        int i = 0;
        while (i < expression.length())
        {
            char c = expression.charAt(i);

            // number (digits / decimal) or unary minus
            if (Character.isDigit(c) || c == '.' || isUnaryMinus(expression, i))
            {
                int sign = 1;

                if (isUnaryMinus(expression, i))
                {
                    sign = -1;
                    i++; // skip '-'
                }

                StringBuilder sb = new StringBuilder();
                boolean hasDot = false;

                while (i < expression.length())
                {
                    char ch = expression.charAt(i);

                    if (Character.isDigit(ch))
                    {
                        sb.append(ch);
                        i++;
                        continue;
                    }

                    if (ch == '.' && !hasDot)
                    {
                        hasDot = true;
                        sb.append(ch);
                        i++;
                        continue;
                    }

                    break;
                }

                if (sb.length() == 0 || sb.toString().equals("."))
                {
                    throw new IllegalArgumentException("Invalid number in: " + expression);
                }

                double num = Double.parseDouble(sb.toString());
                values.push(sign * num);
                continue;
            }

            if (isOperator(c))
            {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c))
                {
                    applyTopOperator(values, ops);
                }
                ops.push(c);
                i++;
                continue;
            }

            throw new IllegalArgumentException("Unexpected character: " + c);
        }

        while (!ops.isEmpty())
        {
            applyTopOperator(values, ops);
        }

        if (values.size() != 1)
        {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }

        return values.pop();
    }

    private boolean isUnaryMinus(String expression, int index)
    {
        if (expression.charAt(index) != '-')
        {
            return false;
        }

        if (index == 0)
        {
            return true;
        }

        char prev = expression.charAt(index - 1);
        return prev == '+' || prev == '-' || prev == '*' || prev == '/';
    }

    private boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedence(char op)
    {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    private void applyTopOperator(Deque<Double> values, Deque<Character> ops)
    {
        char op = ops.pop();
        double b = values.pop();
        double a = values.pop();

        double result;
        switch (op)
        {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }

        values.push(result);
    }
}
