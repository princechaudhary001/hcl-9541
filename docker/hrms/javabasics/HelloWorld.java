package javabasics;

/** Module 1: Java Basics - first program, structure of a Java class. */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.print("print() stays on the same line, ");
        System.out.println("println() moves to the next line.");
        System.out.printf("printf: %s is %d years old, GPA %.2f%n", "Prince", 21, 8.456);
    }
}
