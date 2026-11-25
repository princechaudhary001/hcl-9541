package OOPS;

/** OOP pillar 4: Abstraction - abstract classes and interfaces (default/static methods). */
public class AbstractionDemo {

    static abstract class Vehicle {                    // cannot be instantiated
        abstract void start();                         // no body
        void stop() { System.out.println("Vehicle stops"); }   // concrete method
    }

    static class Car extends Vehicle {
        @Override void start() { System.out.println("Car starts with a key"); }
    }

    interface Payment {
        void pay(double amount);
        default void receipt() { System.out.println("Receipt generated"); }   // Java 8+
        static void info() { System.out.println("Payment interface"); }
    }

    static class UpiPayment implements Payment {
        @Override public void pay(double amount) { System.out.println("Paid " + amount + " via UPI"); }
    }

    static class CardPayment implements Payment {
        @Override public void pay(double amount) { System.out.println("Paid " + amount + " via Card"); }
        @Override public void receipt() { System.out.println("Card receipt with last 4 digits"); }
    }

    interface Flyer { default String move() { return "fly"; } }
    interface Swimmer { default String move() { return "swim"; } }
    static class Duck implements Flyer, Swimmer {      // multiple inheritance via interfaces
        @Override public String move() { return Flyer.super.move() + " and " + Swimmer.super.move(); }
    }

    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
        v.stop();

        Payment.info();
        Payment[] methods = {new UpiPayment(), new CardPayment()};
        for (Payment p : methods) { p.pay(499.0); p.receipt(); }

        System.out.println("Duck can " + new Duck().move());
    }
}
