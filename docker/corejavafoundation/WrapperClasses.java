package corejavafoundation;

/** Module 2: Core Java - wrapper classes, autoboxing/unboxing, Integer cache. */
public class WrapperClasses {
    public static void main(String[] args) {
        int prim = 10;
        Integer boxed = prim;        // autoboxing
        int back = boxed;            // unboxing
        System.out.println(boxed + " " + back);

        System.out.println("Integer.parseInt: " + Integer.parseInt("42"));
        System.out.println("Integer.valueOf: " + Integer.valueOf("42"));
        System.out.println("toBinaryString(10): " + Integer.toBinaryString(10));
        System.out.println("MAX: " + Integer.MAX_VALUE + ", compare: " + Integer.compare(3, 7));
        System.out.println("Character: " + Character.isDigit('7') + " " + Character.isLetter('x') + " " + Character.toUpperCase('q'));

        // Integer cache: values -128..127 are cached, so == works only in that range
        Integer p = 127, q = 127;
        Integer r = 128, s = 128;
        System.out.println("127 == 127: " + (p == q));
        System.out.println("128 == 128: " + (r == s));
        System.out.println("128 equals 128: " + r.equals(s));

        // Unboxing null -> NullPointerException
        try {
            Integer nothing = null;
            int n = nothing;
        } catch (NullPointerException e) {
            System.out.println("NPE while unboxing null");
        }
    }
}
