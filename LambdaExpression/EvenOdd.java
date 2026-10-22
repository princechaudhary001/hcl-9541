package LambdaExpression;

// 1. Interface with an abstract method that takes one number and returns boolean
interface NumberChecker {
    boolean check(int number);
}

public class EvenOdd {
    public static void main(String[] args) {

        // 2. Lambda expression to check if a number is Even
        // (number % 2 == 0 hoga toh true return karega)
        NumberChecker isEven = (n) -> n % 2 == 0;

        // 3. Lambda expression to check if a number is Odd
        // (number % 2 != 0 hoga toh true return karega)
        NumberChecker isOdd = (n) -> n % 2 != 0;

        // Test numbers
        int num1 = 10;
        int num2 = 7;

        System.out.println("--- Even and Odd Check using Lambda Expressions ---");

        System.out.println(num1 + " is Even? " + isEven.check(num1)); // true
        System.out.println(num1 + " is Odd? " + isOdd.check(num1));   // false

        System.out.println("--------------------------------");

        System.out.println(num2 + " is Even? " + isEven.check(num2)); // false
        System.out.println(num2 + " is Odd? " + isOdd.check(num2));   // true
    }
}