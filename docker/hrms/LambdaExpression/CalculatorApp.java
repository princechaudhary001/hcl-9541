package LambdaExpression;

// 1. Interface with an abstract method (Functional Interface)
interface Calculator {
    double calculate(double a, double b);
}

public class CalculatorApp {
    public static void main(String[] args) {

        // 2. Lambda expression for Addition (+)
        Calculator addition = (a, b) -> a + b;

        // 3. Lambda expression for Subtraction (-)
        Calculator subtraction = (a, b) -> a - b;

        // 4. Lambda expression for Multiplication (*)
        Calculator multiplication = (a, b) -> a * b;

        // 5. Lambda expression for Division (/) with zero check
        Calculator division = (a, b) -> {
            if (b == 0) {
                System.out.println("Error: Division by zero!");
                return 0;
            }
            return a / b;
        };

        // Testing the operations
        double num1 = 20.0;
        double num2 = 5.0;

        System.out.println("--- Arithmetic Operations using Lambda Expressions ---");
        System.out.println("Numbers: " + num1 + " and " + num2);
        System.out.println("Addition: " + addition.calculate(num1, num2));
        System.out.println("Subtraction: " + subtraction.calculate(num1, num2));
        System.out.println("Multiplication: " + multiplication.calculate(num1, num2));
        System.out.println("Division: " + division.calculate(num1, num2));
    }
}