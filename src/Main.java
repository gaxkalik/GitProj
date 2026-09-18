import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Simple Calculator ---");
        System.out.println("Supported operations: +, -, *, /");
        
        try {
            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter operator (+, -, *, /): ");
            String op = scanner.nextLine().trim();
            
            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(scanner.nextLine());
            
            double result = 0;
            boolean valid = true;
            
            switch (op) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                        valid = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("Error: Unsupported operation.");
                    valid = false;
            }
            
            if (valid) {
                System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, op, num2, result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter numerical values.");
        } finally {
            scanner.close();
        }
    }
}
