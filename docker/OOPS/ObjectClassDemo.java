package OOPS;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/** OOP: Object class - toString, equals/hashCode contract, instanceof, cloning idea. */
public class ObjectClassDemo {

    static class Employee {
        final int id;
        final String name;
        Employee(int id, String name) { this.id = id; this.name = name; }

        @Override public String toString() { return "Employee{id=" + id + ", name=" + name + "}"; }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Employee e)) return false;      // pattern matching (Java 16+)
            return id == e.id && Objects.equals(name, e.name);
        }

        @Override public int hashCode() { return Objects.hash(id, name); }
    }

    static class NoOverride {
        final int id;
        NoOverride(int id) { this.id = id; }
    }

    public static void main(String[] args) {
        Employee a = new Employee(1, "Ravi");
        Employee b = new Employee(1, "Ravi");
        System.out.println(a);
        System.out.println("a == b: " + (a == b) + ", a.equals(b): " + a.equals(b));
        System.out.println("hashCodes equal: " + (a.hashCode() == b.hashCode()));

        Set<Employee> set = new HashSet<>();
        set.add(a); set.add(b);
        System.out.println("HashSet size with equals/hashCode: " + set.size());

        Set<NoOverride> bad = new HashSet<>();
        bad.add(new NoOverride(1)); bad.add(new NoOverride(1));
        System.out.println("HashSet size WITHOUT equals/hashCode: " + bad.size());
    }
}
