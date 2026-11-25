package javabasics;

/** Module 1: Methods - parameters, return values, overloading, varargs, recursion, pass-by-value. */
public class MethodsDemo {
    static int add(int a, int b) { return a + b; }
    static double add(double a, double b) { return a + b; }        // overloaded
    static int add(int a, int b, int c) { return a + b + c; }      // overloaded

    static int sumAll(int... nums) {                              // varargs
        int s = 0;
        for (int n : nums) s += n;
        return s;
    }

    static long factorial(int n) { return n <= 1 ? 1 : n * factorial(n - 1); }   // recursion

    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    static void changePrimitive(int x) { x = 99; }                // copy of the value
    static void changeArray(int[] a) { a[0] = 99; }               // copy of the reference

    public static void main(String[] args) {
        System.out.println(add(2, 3) + " " + add(2.5, 3.5) + " " + add(1, 2, 3));
        System.out.println("sumAll() = " + sumAll() + ", sumAll(1,2,3,4) = " + sumAll(1, 2, 3, 4));
        System.out.println("5! = " + factorial(5) + ", gcd(48, 18) = " + gcd(48, 18));

        int x = 1;
        int[] arr = {1};
        changePrimitive(x);
        changeArray(arr);
        System.out.println("Java is always pass-by-value -> x = " + x + ", arr[0] = " + arr[0]);
    }
}
