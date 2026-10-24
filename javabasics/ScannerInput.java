package javabasics;

import java.util.Scanner;

/** Module 1: Reading console input with Scanner. */
public class ScannerInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Hello " + name + ", sum = " + (a + b) + ", product = " + (a * b));
        sc.close();
    }
}
