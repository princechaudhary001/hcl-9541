package LambdaExpression;

import java.util.function.Predicate;

public class PredicateEvenOdd {
    public static void main(String[] args) {
        // Define the predicate (following standard camelCase naming conventions)
        Predicate<Integer> isEven = n -> n % 2 == 0;

        int n = 25;

        // Executable logic must be inside a method
        if (isEven.test(n)) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }
}