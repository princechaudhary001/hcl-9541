package corejavafoundation;

import java.util.Arrays;

/** Module 2: Core Java - String immutability, string pool, common methods, StringBuilder. */
public class StringHandling {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";             // same object from the string pool
        String c = new String("hello"); // new heap object
        System.out.println("a == b: " + (a == b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a.equals(c): " + a.equals(c));
        System.out.println("a == c.intern(): " + (a == c.intern()));

        String s = "  Java Programming  ";
        System.out.println("[" + s.trim() + "] length=" + s.length());
        String t = s.trim();
        System.out.println(t.toUpperCase() + " | " + t.toLowerCase());
        System.out.println("charAt(5)=" + t.charAt(5) + ", indexOf(\"Pro\")=" + t.indexOf("Pro")
                + ", substring(5)=" + t.substring(5) + ", substring(0,4)=" + t.substring(0, 4));
        System.out.println("replace=" + t.replace('a', '@') + ", contains=" + t.contains("gram"));
        System.out.println("split=" + Arrays.toString("a,b,,c".split(",")));
        System.out.println("join=" + String.join("-", "2026", "10", "10"));
        System.out.println("compareTo=" + "apple".compareTo("banana") + ", equalsIgnoreCase=" + "Java".equalsIgnoreCase("JAVA"));

        // Immutability: methods return a NEW string
        String x = "abc";
        x.concat("def");
        System.out.println("x unchanged: " + x);
        x = x.concat("def");
        System.out.println("x reassigned: " + x);

        // StringBuilder is mutable (StringBuffer is the synchronized version)
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Core").insert(0, ">> ").reverse();
        System.out.println(sb);
        sb.reverse().deleteCharAt(0).setCharAt(0, '#');
        System.out.println(sb);

        // Classic: palindrome and character count
        String word = "madam";
        System.out.println(word + " palindrome? " + new StringBuilder(word).reverse().toString().equals(word));
        int vowels = 0;
        for (char ch : "education".toCharArray()) if ("aeiou".indexOf(ch) >= 0) vowels++;
        System.out.println("vowels in education = " + vowels);
    }
}
