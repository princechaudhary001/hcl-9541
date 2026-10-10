package CollectionFrameWork;

import java.util.*;

/** List interface via ArrayList: add/get/set/remove, search, sort, sublist, List.of immutability. */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add(1, "Go");                         // insert at index
        System.out.println("1. " + list);

        list.set(0, "Kotlin");
        System.out.println("2. get(2)=" + list.get(2) + ", size=" + list.size() + ", " + list);

        list.remove("C++");                        // by object
        list.remove(0);                            // by index
        System.out.println("3. " + list);

        List<Integer> nums = new ArrayList<>(List.of(10, 20, 30, 20));
        nums.remove(Integer.valueOf(20));          // remove(Object) vs remove(int index)
        System.out.println("4. " + nums + ", indexOf(20)=" + nums.indexOf(20) + ", lastIndexOf(20)=" + nums.lastIndexOf(20));

        List<Integer> data = new ArrayList<>(Arrays.asList(5, 3, 9, 1, 7));
        Collections.sort(data);
        System.out.println("5. ascending " + data);
        data.sort(Comparator.reverseOrder());
        System.out.println("6. descending " + data + ", subList(1,3)=" + data.subList(1, 3));

        // Three ways to iterate
        for (int n : data) System.out.print(n + " ");
        System.out.println("<- for-each");
        data.forEach(n -> System.out.print(n + " "));
        System.out.println("<- forEach lambda");
        for (Iterator<Integer> it = data.iterator(); it.hasNext(); ) if (it.next() % 3 == 0) it.remove();
        System.out.println("7. after removing multiples of 3: " + data);

        // Immutable lists
        List<String> fixed = List.of("a", "b");
        try { fixed.add("c"); } catch (UnsupportedOperationException e) { System.out.println("8. List.of is immutable"); }

        // Arrays.asList is fixed-size: set() works, add() does not
        List<Integer> view = Arrays.asList(1, 2, 3);
        view.set(0, 99);
        try { view.add(4); } catch (UnsupportedOperationException e) { System.out.println("9. Arrays.asList is fixed-size " + view); }

        // Capacity growth: new capacity = old + old/2
        System.out.println("10. Default capacity 10, grows by 1.5x when full");
    }
}
