package corejavafoundation;

/** Module 2: Core Java - static members, static/instance blocks, final keyword. */
public class StaticAndFinal {
    static int count = 0;                 // shared by all objects
    final int id;                         // blank final, set once in constructor
    static final double PI = 3.14159;     // constant

    static {                              // runs once when the class is loaded
        System.out.println("static block executed");
    }

    {                                     // runs before every constructor
        count++;
        System.out.println("instance block executed, count = " + count);
    }

    StaticAndFinal() {
        this.id = count;
        System.out.println("constructor executed, id = " + id);
    }

    static void showCount() {             // static methods cannot use 'this' or instance fields
        System.out.println("Objects created: " + count);
    }

    final void cannotOverride() { System.out.println("final method"); }

    public static void main(String[] args) {
        new StaticAndFinal();
        new StaticAndFinal();
        showCount();
        System.out.println("PI = " + PI);

        final int[] arr = {1, 2};
        arr[0] = 10;                       // contents can change; the reference cannot
        System.out.println("final array contents are mutable: " + arr[0]);
    }
}
