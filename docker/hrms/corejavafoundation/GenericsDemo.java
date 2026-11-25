package corejavafoundation;

import java.util.ArrayList;
import java.util.List;

/** Module 2: Core Java - generics: generic class, generic method, bounded types, wildcards. */
public class GenericsDemo {

    static class Box<T> {
        private T value;
        Box(T value) { this.value = value; }
        T get() { return value; }
    }

    static <T extends Comparable<T>> T maxOf(T a, T b) {       // bounded type parameter
        return a.compareTo(b) >= 0 ? a : b;
    }

    static double sum(List<? extends Number> list) {           // wildcard: read-only view
        double s = 0;
        for (Number n : list) s += n.doubleValue();
        return s;
    }

    static void fill(List<? super Integer> list) {             // wildcard: can add Integers
        list.add(1); list.add(2);
    }

    static <T> void printAll(T[] arr) {
        for (T t : arr) System.out.print(t + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Box<String> s = new Box<>("generic");
        Box<Integer> i = new Box<>(42);
        System.out.println(s.get() + " " + i.get());

        System.out.println("maxOf(3, 9) = " + maxOf(3, 9) + ", maxOf(\"pear\", \"apple\") = " + maxOf("pear", "apple"));
        System.out.println("sum = " + sum(List.of(1, 2.5, 3L)));

        List<Number> nums = new ArrayList<>();
        fill(nums);
        System.out.println(nums);
        printAll(new String[]{"a", "b", "c"});

        // Type safety: a raw list would only fail at runtime
        List<String> names = new ArrayList<>();
        names.add("only strings");
        // names.add(10);   // compile-time error
        System.out.println(names);
    }
}
