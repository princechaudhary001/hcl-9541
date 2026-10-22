package CollectionFrameWork;

import java.util.*;

/** Comparable (natural order, inside the class) vs Comparator (custom order, outside). */
public class ComparableComparatorDemo {

    static class Employee implements Comparable<Employee> {
        String name; int age; double salary;
        Employee(String name, int age, double salary) { this.name = name; this.age = age; this.salary = salary; }

        @Override public int compareTo(Employee o) { return Integer.compare(this.age, o.age); }   // natural order: age
        @Override public String toString() { return name + "(" + age + ", " + salary + ")"; }
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>(List.of(
                new Employee("Ravi", 30, 50000),
                new Employee("Anita", 25, 65000),
                new Employee("Zoya", 28, 65000),
                new Employee("Karan", 35, 40000)));

        Collections.sort(list);                                           // uses compareTo
        System.out.println("by age (Comparable)      : " + list);

        list.sort(Comparator.comparing(e -> e.name));
        System.out.println("by name (Comparator)     : " + list);

        list.sort(Comparator.comparingDouble((Employee e) -> e.salary).reversed().thenComparing(e -> e.name));
        System.out.println("salary desc, then name   : " + list);

        list.sort((a, b) -> b.age - a.age);
        System.out.println("age desc (lambda)        : " + list);

        Employee[] arr = list.toArray(new Employee[0]);
        Arrays.sort(arr, Comparator.comparing((Employee e) -> e.name).reversed());
        System.out.println("array, name desc         : " + Arrays.toString(arr));

        // TreeSet / TreeMap / PriorityQueue use Comparable or a supplied Comparator
        TreeSet<Employee> sorted = new TreeSet<>(list);
        System.out.println("TreeSet natural order    : " + sorted);
    }
}
