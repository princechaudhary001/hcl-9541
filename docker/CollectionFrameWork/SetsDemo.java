package CollectionFrameWork;

import java.util.*;

/** Set interface: HashSet vs LinkedHashSet vs TreeSet, set operations. */
public class SetsDemo {
    public static void main(String[] args) {
        int[] input = {30, 10, 20, 10, 40, 30};

        Set<Integer> hash = new HashSet<>();
        Set<Integer> linked = new LinkedHashSet<>();
        Set<Integer> tree = new TreeSet<>();
        for (int n : input) {
            hash.add(n);
            linked.add(n);
            tree.add(n);
        }
        System.out.println("HashSet       (no guaranteed order): " + hash);
        System.out.println("LinkedHashSet (insertion order)    : " + linked);
        System.out.println("TreeSet       (sorted)             : " + tree);
        System.out.println("add() returns false for duplicate: " + hash.add(10));

        TreeSet<Integer> ts = new TreeSet<>(List.of(5, 15, 25, 35, 45));
        System.out.println("first=" + ts.first() + ", last=" + ts.last());
        System.out.println("floor(20)=" + ts.floor(20) + ", ceiling(20)=" + ts.ceiling(20)
                + ", lower(15)=" + ts.lower(15) + ", higher(15)=" + ts.higher(15));
        System.out.println("headSet(25)=" + ts.headSet(25) + ", tailSet(25)=" + ts.tailSet(25) + ", descending=" + ts.descendingSet());

        Set<String> a = new TreeSet<>(Set.of("java", "python", "go"));
        Set<String> b = new TreeSet<>(Set.of("go", "rust", "java"));
        Set<String> union = new TreeSet<>(a);        union.addAll(b);
        Set<String> inter = new TreeSet<>(a);        inter.retainAll(b);
        Set<String> diff = new TreeSet<>(a);         diff.removeAll(b);
        System.out.println("union=" + union + ", intersection=" + inter + ", difference=" + diff);

        // Find duplicates in a list
        List<Integer> nums = List.of(1, 2, 3, 2, 4, 1, 5);
        Set<Integer> seen = new HashSet<>(), dups = new TreeSet<>();
        for (int n : nums) if (!seen.add(n)) dups.add(n);
        System.out.println("duplicates in " + nums + " = " + dups);

        // TreeSet with a custom comparator: sort strings by length, then alphabetically
        Set<String> byLen = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        byLen.addAll(List.of("banana", "kiwi", "apple", "fig", "cherry"));
        System.out.println("by length: " + byLen);
    }
}
