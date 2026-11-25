package OOPS;

/** OOP pillar 2: Inheritance - single, multilevel, hierarchical, super keyword, constructor chaining. */
public class InheritanceDemo {
    static class Animal {
        protected String name;
        Animal(String name) { this.name = name; System.out.println("Animal constructor: " + name); }
        void eat() { System.out.println(name + " eats"); }
    }

    static class Dog extends Animal {                  // single inheritance
        Dog(String name) { super(name); System.out.println("Dog constructor"); }
        void bark() { System.out.println(name + " barks"); }
        @Override void eat() { super.eat(); System.out.println(name + " eats bones"); }
    }

    static class Puppy extends Dog {                   // multilevel: Animal -> Dog -> Puppy
        Puppy(String name) { super(name); System.out.println("Puppy constructor"); }
        void weep() { System.out.println(name + " weeps"); }
    }

    static class Cat extends Animal {                  // hierarchical: Animal -> Dog, Cat
        Cat(String name) { super(name); }
        void meow() { System.out.println(name + " meows"); }
    }

    public static void main(String[] args) {
        Puppy p = new Puppy("Tommy");                  // constructors run parent first
        p.eat();
        p.bark();
        p.weep();
        new Cat("Kitty").meow();

        System.out.println("p instanceof Animal: " + (p instanceof Animal));
        // Java has no multiple inheritance of classes (diamond problem); use interfaces instead.
    }
}
