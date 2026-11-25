package OOPS;

/** OOP pillar 3: Polymorphism - compile-time (overloading) and runtime (overriding, upcasting). */
public class PolymorphismDemo {

    static class Calculator {                          // compile-time polymorphism
        int add(int a, int b) { return a + b; }
        double add(double a, double b) { return a + b; }
        int add(int a, int b, int c) { return a + b + c; }
    }

    static class Shape {
        double area() { return 0; }
        String describe() { return "Shape with area " + String.format("%.2f", area()); }
    }

    static class Circle extends Shape {
        double r;
        Circle(double r) { this.r = r; }
        @Override double area() { return Math.PI * r * r; }
    }

    static class Rectangle extends Shape {
        double w, h;
        Rectangle(double w, double h) { this.w = w; this.h = h; }
        @Override double area() { return w * h; }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(1, 2) + " " + c.add(1.5, 2.5) + " " + c.add(1, 2, 3));

        // Runtime polymorphism: the JVM picks the method from the actual object type
        Shape[] shapes = {new Circle(3), new Rectangle(4, 5), new Shape()};
        for (Shape s : shapes) System.out.println(s.getClass().getSimpleName() + " -> " + s.describe());

        // Fields and static methods are NOT overridden (resolved by reference type)
        System.out.println("Static methods are hidden, not overridden: see OOPS.Main and OOPS.child");
    }
}
