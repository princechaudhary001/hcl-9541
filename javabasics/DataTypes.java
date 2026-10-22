package javabasics;

/** Module 1: Primitive data types, their sizes/ranges, and variables. */
public class DataTypes {
    public static void main(String[] args) {
        byte b = 127;                 // 8-bit
        short s = 32_000;             // 16-bit
        int i = 2_000_000_000;        // 32-bit
        long l = 9_000_000_000L;      // 64-bit, needs L suffix
        float f = 3.14f;              // 32-bit, needs f suffix
        double d = 3.141592653589793; // 64-bit (default for decimals)
        char c = 'A';                 // 16-bit unicode
        boolean flag = true;

        System.out.println("byte=" + b + ", short=" + s + ", int=" + i + ", long=" + l);
        System.out.println("float=" + f + ", double=" + d);
        System.out.println("char=" + c + ", char as int=" + (int) c + ", boolean=" + flag);

        System.out.println("byte range : " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("short range: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("int range  : " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("long range : " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);

        // Overflow wraps around
        int max = Integer.MAX_VALUE;
        System.out.println("MAX_VALUE + 1 = " + (max + 1));

        // var (Java 10+) - type inferred by the compiler
        var inferred = 42;
        System.out.println("var inferred as int: " + inferred);

        // Default values apply only to fields, not local variables
        System.out.println("Default int field: " + Defaults.number + ", boolean: " + Defaults.ok + ", String: " + Defaults.text);
    }

    static class Defaults {
        static int number;
        static boolean ok;
        static String text;
    }
}
