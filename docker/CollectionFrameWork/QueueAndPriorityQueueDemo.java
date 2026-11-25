package CollectionFrameWork;

import java.util.*;

/** Queue family: PriorityQueue (heap), ArrayDeque (double-ended), Queue method pairs. */
public class QueueAndPriorityQueueDemo {

    record Task(String name, int priority) {}

    public static void main(String[] args) {
        // Min-heap by default: head is the smallest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(List.of(40, 10, 30, 20));
        System.out.println("minHeap peek = " + minHeap.peek());
        StringBuilder sb = new StringBuilder();
        while (!minHeap.isEmpty()) sb.append(minHeap.poll()).append(' ');
        System.out.println("poll order (ascending): " + sb);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(List.of(40, 10, 30, 20));
        System.out.println("maxHeap peek = " + maxHeap.peek());

        // K-th largest element using a min-heap of size k
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr) { pq.offer(n); if (pq.size() > k) pq.poll(); }
        System.out.println(k + "rd largest in " + Arrays.toString(arr) + " = " + pq.peek());

        // Custom priority
        PriorityQueue<Task> tasks = new PriorityQueue<>(Comparator.comparingInt(Task::priority));
        tasks.add(new Task("Write report", 3));
        tasks.add(new Task("Fix prod bug", 1));
        tasks.add(new Task("Reply emails", 2));
        while (!tasks.isEmpty()) System.out.println("  run -> " + tasks.poll());

        // Queue method pairs: add/offer, remove/poll, element/peek
        Queue<String> q = new ArrayDeque<>();
        q.offer("A"); q.offer("B");
        System.out.println("peek=" + q.peek() + ", poll=" + q.poll() + ", poll=" + q.poll() + ", poll on empty=" + q.poll());
        try { q.remove(); } catch (NoSuchElementException e) { System.out.println("remove() on empty throws NoSuchElementException"); }

        // Deque: both ends
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(2); dq.addFirst(1); dq.addLast(3); dq.addLast(4);
        System.out.println("deque = " + dq + ", pollFirst=" + dq.pollFirst() + ", pollLast=" + dq.pollLast() + " -> " + dq);
    }
}
