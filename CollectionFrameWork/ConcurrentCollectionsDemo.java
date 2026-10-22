package CollectionFrameWork;

import java.util.*;
import java.util.concurrent.*;

/** Thread-safe collections: Vector/Hashtable (legacy), ConcurrentHashMap, CopyOnWriteArrayList. */
public class ConcurrentCollectionsDemo {
    public static void main(String[] args) throws Exception {
        // Fail-safe: CopyOnWriteArrayList iterates over a snapshot, so no exception
        List<Integer> cow = new CopyOnWriteArrayList<>(List.of(1, 2, 3));
        for (Integer n : cow) if (n == 2) cow.add(99);
        System.out.println("CopyOnWriteArrayList: " + cow);

        // ConcurrentHashMap: atomic merge from multiple threads
        Map<String, Integer> counter = new ConcurrentHashMap<>();
        Runnable task = () -> { for (int i = 0; i < 1000; i++) counter.merge("hits", 1, Integer::sum); };
        Thread t1 = new Thread(task), t2 = new Thread(task);
        t1.start(); t2.start(); t1.join(); t2.join();
        System.out.println("ConcurrentHashMap hits (expect 2000): " + counter.get("hits"));

        // Legacy synchronized classes
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("a", 1);
        try { ht.put(null, 1); } catch (NullPointerException e) { System.out.println("Hashtable rejects null keys"); }
        Vector<Integer> vec = new Vector<>(List.of(1, 2, 3));
        System.out.println("Vector (synchronized ArrayList): " + vec);

        // Blocking queue (producer/consumer building block)
        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(2);
        System.out.println("offer 1: " + bq.offer(1) + ", offer 2: " + bq.offer(2) + ", offer 3 (full): " + bq.offer(3));
        System.out.println("take: " + bq.take());
    }
}
