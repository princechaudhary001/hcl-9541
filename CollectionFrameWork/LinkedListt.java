package CollectionFrameWork;
import java.util.*;

public class LinkedListt{
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        // Add
        ll.add("B");
        ll.add("C");
        ll.addFirst("A");
        ll.addLast("D");
        ll.add(2, "X");                       // insert at index 2
        System.out.println("1. " + ll);       // [A, B, X, C, D]

        // Queue methods (head = first element)
        ll.offer("E");                        // add at tail
        System.out.println("2. peek=" + ll.peek() + ", poll=" + ll.poll() + " -> " + ll);

        // Deque / stack methods
        ll.offerFirst("Z");                   // add at head
        ll.pollLast();                        // remove tail
        ll.push("P");                         // push = addFirst
        System.out.println("3. pop=" + ll.pop() + " -> " + ll);

        // Search
        System.out.println("4. contains(X)=" + ll.contains("X") + ", indexOf(C)=" + ll.indexOf("C"));

        // Remove
        ll.remove("X");                       // by value
        ll.removeIf(s -> s.equals("Z"));      // by condition
        System.out.println("5. " + ll);

        // Sort / reverse
        ll.add("A");
        Collections.sort(ll);
        Collections.reverse(ll);
        System.out.println("6. " + ll);

        // Remove while iterating (use Iterator, not for-each)
        Iterator<String> it = ll.iterator();
        while (it.hasNext()) {
            if (it.next().equals("C")) it.remove();
        }
        System.out.println("7. " + ll);

        // Iterate backwards
        System.out.print("8. reverse: ");
        ListIterator<String> li = ll.listIterator(ll.size());
        while (li.hasPrevious()) System.out.print(li.previous() + " ");
        System.out.println();

        // To array
        String[] arr = ll.toArray(new String[0]);
        System.out.println("9. " + Arrays.toString(arr));
    }
}