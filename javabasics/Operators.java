package javabasics;

/** Module 1: Arithmetic, relational, logical, bitwise, assignment, ternary operators. */
public class Operators {
    public static void main(String[] args) {
        int a = 17, b = 5;
        System.out.println("Arithmetic: " + (a + b) + " " + (a - b) + " " + (a * b) + " " + (a / b) + " " + (a % b));
        System.out.println("Integer vs double division: " + (a / b) + " vs " + ((double) a / b));

        // Increment / decrement
        int x = 5;
        System.out.println("x++ = " + (x++) + ", now x = " + x);
        System.out.println("++x = " + (++x) + ", now x = " + x);

        // Relational & logical
        System.out.println("a > b: " + (a > b) + ", a == b: " + (a == b) + ", a != b: " + (a != b));
        boolean p = true, q = false;
        System.out.println("&&: " + (p && q) + ", ||: " + (p || q) + ", !: " + (!p));

        // Short-circuit: right side is skipped when result is already known
        int n = 0;
        boolean r = (n != 0) && (10 / n > 1);   // no ArithmeticException
        System.out.println("Short-circuit result: " + r);

        // Bitwise
        System.out.println("5 & 3 = " + (5 & 3) + ", 5 | 3 = " + (5 | 3) + ", 5 ^ 3 = " + (5 ^ 3) + ", ~5 = " + (~5));
        System.out.println("5 << 1 = " + (5 << 1) + ", 20 >> 2 = " + (20 >> 2) + ", -20 >>> 28 = " + (-20 >>> 28));

        // Compound assignment does an implicit cast
        byte by = 10;
        by += 5;   // OK, but by = by + 5 would not compile
        System.out.println("byte after += : " + by);

        // Ternary
        int marks = 72;
        System.out.println(marks >= 40 ? "Pass" : "Fail");
    }
}
