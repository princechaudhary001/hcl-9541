package CollectionFrameWork;

import java.util.*;

/** Map interface: HashMap vs LinkedHashMap vs TreeMap, and the modern Map API. */
public class MapTypesDemo {
    public static void main(String[] args) {
        Map<String, Integer> hash = new HashMap<>();
        Map<String, Integer> linked = new LinkedHashMap<>();
        Map<String, Integer> tree = new TreeMap<>();
        String[] keys = {"banana", "apple", "cherry", "date"};
        int v = 1;
        for (String k : keys) { hash.put(k, v); linked.put(k, v); tree.put(k, v); v++; }

        System.out.println("HashMap       : " + hash);
        System.out.println("LinkedHashMap : " + linked);
        System.out.println("TreeMap       : " + tree);

        Map<String, Integer> m = new HashMap<>();
        m.put("a", 1);
        System.out.println("put returns old value: " + m.put("a", 2));
        m.putIfAbsent("b", 10);
        m.putIfAbsent("b", 99);                        // ignored
        System.out.println("getOrDefault(z) = " + m.getOrDefault("z", -1));
        System.out.println("containsKey(a) = " + m.containsKey("a") + ", containsValue(10) = " + m.containsValue(10));
        m.merge("a", 5, Integer::sum);                 // a = 2 + 5
        m.computeIfAbsent("c", k -> 100);
        m.compute("b", (k, old) -> old == null ? 1 : old * 2);
        System.out.println("after merge/compute: " + new TreeMap<>(m));

        // Three ways to iterate a map
        for (Map.Entry<String, Integer> e : new TreeMap<>(m).entrySet())
            System.out.print(e.getKey() + "=" + e.getValue() + " ");
        System.out.println("<- entrySet");
        for (String k : new TreeMap<>(m).keySet()) System.out.print(k + " ");
        System.out.println("<- keySet");
        m.forEach((k, val) -> { if (val > 50) System.out.println("big value: " + k + "=" + val); });

        // HashMap allows one null key and many null values; TreeMap and Hashtable reject null keys
        Map<String, String> nulls = new HashMap<>();
        nulls.put(null, "nullKey");
        nulls.put("x", null);
        System.out.println("HashMap with nulls: " + nulls);
        try { new TreeMap<String, String>().put(null, "x"); }
        catch (NullPointerException e) { System.out.println("TreeMap rejects null key"); }

        TreeMap<Integer, String> grades = new TreeMap<>(Map.of(90, "A", 75, "B", 60, "C", 40, "D"));
        System.out.println("floorEntry(80) = " + grades.floorEntry(80) + ", firstKey = " + grades.firstKey()
                + ", descendingMap = " + grades.descendingMap());

        // LinkedHashMap as an LRU cache
        Map<Integer, String> lru = new LinkedHashMap<>(16, 0.75f, true) {
            @Override protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) { return size() > 3; }
        };
        lru.put(1, "a"); lru.put(2, "b"); lru.put(3, "c");
        lru.get(1);                                    // 1 becomes most recently used
        lru.put(4, "d");                               // evicts 2
        System.out.println("LRU cache: " + lru);
    }
}
