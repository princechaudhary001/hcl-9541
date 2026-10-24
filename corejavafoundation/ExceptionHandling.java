package corejavafoundation;

/** Module 2: Core Java - try/catch/finally, multi-catch, throw/throws, custom exceptions, try-with-resources. */
public class ExceptionHandling {

    static class InsufficientBalanceException extends Exception {     // checked
        InsufficientBalanceException(String msg) { super(msg); }
    }

    static class Resource implements AutoCloseable {
        private final String name;
        Resource(String name) { this.name = name; System.out.println("open " + name); }
        @Override public void close() { System.out.println("close " + name); }
    }

    static void withdraw(int balance, int amount) throws InsufficientBalanceException {
        if (amount > balance) throw new InsufficientBalanceException("Need " + (amount - balance) + " more");
        System.out.println("Withdrawn " + amount);
    }

    @SuppressWarnings("finally")
    static int finallyOverrides() {
        try { return 1; } finally { System.out.println("finally runs before return"); }
    }

    public static void main(String[] args) {
        try {
            int r = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("finally always runs");
        }

        try {
            Object o = "text";
            Integer i = (Integer) o;
        } catch (ClassCastException | NullPointerException e) {   // multi-catch
            System.out.println("Caught: " + e.getClass().getSimpleName());
        }

        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }

        try {
            withdraw(500, 800);
        } catch (InsufficientBalanceException e) {
            System.out.println("Custom exception: " + e.getMessage());
        }

        try (Resource r1 = new Resource("R1"); Resource r2 = new Resource("R2")) {
            System.out.println("using resources");
            throw new IllegalStateException("boom");
        } catch (IllegalStateException e) {
            System.out.println("Caught after auto-close: " + e.getMessage());
        }

        System.out.println("returned " + finallyOverrides());
    }
}
