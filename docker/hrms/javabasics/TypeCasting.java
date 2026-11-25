package javabasics;

/** Module 1: Widening (implicit) and narrowing (explicit) conversions. */
public class TypeCasting {
    public static void main(String[] args) {
        // Widening: byte -> short -> int -> long -> float -> double (automatic)
        int i = 100;
        long l = i;
        double d = l;
        System.out.println("Widening: " + i + " -> " + l + " -> " + d);

        // Narrowing: manual, can lose data
        double pi = 9.99;
        int truncated = (int) pi;          // fractional part dropped, NOT rounded
        System.out.println("(int) 9.99 = " + truncated + ", Math.round(9.99) = " + Math.round(pi));

        int big = 130;
        byte wrapped = (byte) big;         // 130 does not fit in a byte
        System.out.println("(byte) 130 = " + wrapped);

        // char <-> int
        char ch = 'a';
        System.out.println("'a' + 1 = " + (ch + 1) + ", (char)('a' + 1) = " + (char) (ch + 1));

        // String <-> number
        int parsed = Integer.parseInt("123");
        String text = String.valueOf(456);
        System.out.println(parsed + 1 + " and " + text + 1);
    }
}
