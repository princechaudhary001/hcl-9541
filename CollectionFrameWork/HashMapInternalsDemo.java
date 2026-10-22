package CollectionFrameWork;

import java.util.*;

/** How HashMap uses hashCode()/equals(): custom keys, collisions, and why both must be overridden. */
public class HashMapInternalsDemo {

    static class GoodKey {
        final int id;
        GoodKey(int id) { this.id = id; }
        @Override public boolean equals(Object o) { return o instanceof GoodKey g && g.id == id; }
        @Override public int hashCode() { return Integer.hashCode(id); }
    }

    static class BadKey {                                   // no equals/hashCode -> identity based
        final int id;
        BadKey(int id) { this.id = id; }
    }

    static class CollidingKey {                             // every key lands in the same bucket
        final String name;
        CollidingKey(String name) { this.name = name; }
        @Override public boolean equals(Object o) { return o instanceof CollidingKey c && c.name.equals(name); }
        @Override public int hashCode() { return 1; }
    }

    // HashMap spreads the hash: (h ^ (h >>> 16)) & (n - 1)
    static int bucketIndex(Object key, int tableSize) {
        int h = key.hashCode();
        return (h ^ (h >>> 16)) & (tableSize - 1);
    }

    public static void main(String[] args) {
        Map<GoodKey, String> good = new HashMap<>();
        good.put(new GoodKey(1), "first");
        good.put(new GoodKey(1), "second");                  // same key -> replaces
        System.out.println("GoodKey map size = " + good.size() + ", value = " + good.get(new GoodKey(1)));

        Map<BadKey, String> bad = new HashMap<>();
        bad.put(new BadKey(1), "first");
        bad.put(new BadKey(1), "second");                    // treated as different keys
        System.out.println("BadKey map size  = " + bad.size() + ", get(new BadKey(1)) = " + bad.get(new BadKey(1)));

        Map<CollidingKey, Integer> collide = new HashMap<>();
        for (int i = 0; i < 12; i++) collide.put(new CollidingKey("k" + i), i);
        System.out.println("Colliding keys still work: size=" + collide.size() + ", get(k7)=" + collide.get(new CollidingKey("k7"))
                + " (bucket becomes a tree after 8 collisions when table >= 64)");

        System.out.println("bucket of \"Java\" in a 16-slot table = " + bucketIndex("Java", 16));
        System.out.println("bucket of \"Hash\" in a 16-slot table = " + bucketIndex("Hash", 16));
        System.out.println("Defaults: capacity 16, load factor 0.75 -> resize at 12 entries, capacity doubles");

        // Mutating a key after insertion breaks lookup
        List<Integer> key = new ArrayList<>(List.of(1, 2));
        Map<List<Integer>, String> m = new HashMap<>();
        m.put(key, "value");
        key.add(3);
        System.out.println("Lookup after mutating the key: " + m.get(key) + " (lost!)");
    }
}
