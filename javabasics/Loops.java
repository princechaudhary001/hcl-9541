package javabasics;

/** Module 1: for, while, do-while, for-each, break/continue, labeled break, patterns. */
public class Loops {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) System.out.print(i + " ");
        System.out.println("<- for");

        int n = 5;
        while (n > 0) { System.out.print(n-- + " "); }
        System.out.println("<- while");

        int k = 10;
        do { System.out.print(k + " "); k++; } while (k < 5);   // runs once even though false
        System.out.println("<- do-while (executes at least once)");

        int[] nums = {4, 8, 15, 16, 23, 42};
        int sum = 0;
        for (int v : nums) sum += v;
        System.out.println("for-each sum = " + sum);

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;   // skip evens
            if (i > 7) break;           // stop the loop
            System.out.print(i + " ");
        }
        System.out.println("<- continue/break");

        outer:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i * j == 4) break outer;   // exits both loops
                System.out.print(i * j + " ");
            }
        }
        System.out.println("<- labeled break");

        // Star pattern
        for (int i = 1; i <= 4; i++) {
            System.out.println(" ".repeat(4 - i) + "*".repeat(2 * i - 1));
        }

        // Classic problems: factorial, prime, fibonacci
        long fact = 1;
        for (int i = 2; i <= 10; i++) fact *= i;
        System.out.println("10! = " + fact);

        int num = 29;
        boolean prime = num > 1;
        for (int i = 2; i * i <= num; i++) if (num % i == 0) { prime = false; break; }
        System.out.println(num + " prime? " + prime);

        int a = 0, b = 1;
        System.out.print("Fibonacci: ");
        for (int i = 0; i < 10; i++) { System.out.print(a + " "); int t = a + b; a = b; b = t; }
        System.out.println();
    }
}
