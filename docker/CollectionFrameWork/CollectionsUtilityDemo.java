package CollectionFrameWork;

import java.util.*;

/** java.util.Collections helper methods + iterator behaviour (fail-fast, ListIterator). */
public class CollectionsUtilityDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(4, 8, 1, 9, 3));

        System.out.println("max=" + Collections.max(list) + ", min=" + Collections.min(list));
        Collections.sort(list);
        System.out.println("sorted=" + list + ", binarySearch(8)=" + Collections.binarySearch(list, 8));
        Collections.reverse(list);
        System.out.println("reversed=" + list);
        Collections.swap(list, 0, list.size() - 1);
        System.out.println("swapped ends=" + list);
        Collections.shuffle(list, new Random(42));
        System.out.println("shuffled (seeded)=" + list);
        System.out.println("frequency of 3 = " + Collections.frequency(list, 3));
        Collections.rotate(list, 2);
        System.out.println("rotated by 2=" + list);

        List<Integer> ro = Collections.unmodifiableList(list);
        try { ro.add(1); } catch (UnsupportedOperationException e) { System.out.println("unmodifiableList blocks add()"); }
        List<Integer> sync = Collections.synchronizedList(new ArrayList<>(list));
        System.out.println("synchronizedList size=" + sync.size() + ", nCopies=" + Collections.nCopies(3, "x") + ", emptyList=" + Collections.emptyList());

        // Fail-fast iterator: structural change during for-each throws
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4));
        try {
            for (Integer n : nums) if (n == 2) nums.remove(n);
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException (fail-fast)");
        }
        nums.removeIf(n -> n % 2 == 0);          // safe way
        System.out.println("after removeIf: " + nums);

        // ListIterator: both directions + modify
        List<String> names = new ArrayList<>(List.of("a", "b", "c"));
        ListIterator<String> it = names.listIterator();
        while (it.hasNext()) { String s = it.next(); it.set(s.toUpperCase()); if (s.equals("b")) it.add("B2"); }
        System.out.println("ListIterator edits: " + names);
        while (it.hasPrevious()) System.out.print(it.previous() + " ");
        System.out.println("<- backwards");
    }
}
