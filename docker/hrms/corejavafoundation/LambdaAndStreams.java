package corejavafoundation;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/** Module 2: Core Java - lambdas, functional interfaces, method references, basic Streams. */
public class LambdaAndStreams {
    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Consumer<String> printer = System.out::println;          // method reference
        Supplier<String> supplier = () -> "supplied";
        BiFunction<Integer, Integer, Integer> add = Integer::sum;

        printer.accept("square(7) = " + square.apply(7));
        printer.accept("isEven(10) = " + isEven.test(10));
        printer.accept(supplier.get() + ", add = " + add.apply(3, 4));

        List<Integer> nums = Arrays.asList(5, 12, 8, 3, 20, 7, 12);
        System.out.println("evens squared: " + nums.stream().filter(isEven).map(square).collect(Collectors.toList()));
        System.out.println("sum = " + nums.stream().mapToInt(Integer::intValue).sum());
        System.out.println("max = " + nums.stream().max(Integer::compare).get());
        System.out.println("distinct sorted = " + nums.stream().distinct().sorted().toList());
        System.out.println("any > 15? " + nums.stream().anyMatch(n -> n > 15));

        List<String> words = List.of("java", "collections", "stream", "lambda", "map");
        System.out.println("lengths: " + words.stream().collect(Collectors.toMap(w -> w, String::length)));
        System.out.println("grouped by length: " + words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println("joined: " + words.stream().map(String::toUpperCase).collect(Collectors.joining(", ", "[", "]")));
    }
}
