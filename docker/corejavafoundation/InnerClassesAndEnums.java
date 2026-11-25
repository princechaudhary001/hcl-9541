package corejavafoundation;

/** Module 2: Core Java - nested/inner/anonymous classes, enums, varargs. */
public class InnerClassesAndEnums {
    private String outerField = "outer";

    class Inner {                                  // needs an Outer instance
        void show() { System.out.println("Inner sees: " + outerField); }
    }

    static class StaticNested {                    // no Outer instance needed
        void show() { System.out.println("StaticNested"); }
    }

    interface Greeter { void greet(String name); }

    enum Day {
        MON("Work"), SAT("Rest"), SUN("Rest");
        private final String type;
        Day(String type) { this.type = type; }
        String type() { return type; }
    }

    public static void main(String[] args) {
        InnerClassesAndEnums outer = new InnerClassesAndEnums();
        outer.new Inner().show();
        new StaticNested().show();

        Greeter anon = new Greeter() {             // anonymous class
            @Override public void greet(String name) { System.out.println("Hello " + name); }
        };
        anon.greet("Anonymous");
        Greeter lambda = name -> System.out.println("Hi " + name);   // lambda for a functional interface
        lambda.greet("Lambda");

        for (Day d : Day.values()) System.out.println(d + " (" + d.ordinal() + ") -> " + d.type());
        Day today = Day.valueOf("SAT");
        switch (today) {
            case SAT, SUN -> System.out.println("Weekend");
            default -> System.out.println("Weekday");
        }
    }
}
