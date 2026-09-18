public class Calculator {
    
    public double calculate(double num1, double num2, String operator) throws ArithmeticException, IllegalArgumentException {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Unsupported operation.");
        }
    }
}
