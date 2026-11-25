package CollectionFrameWork;

import java.util.*;
import java.util.stream.Collectors;

/** Classic interview problems using HashMap: word frequency, first non-repeating char, two-sum, anagrams. */
public class WordFrequency {

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = idx.get(target - nums[i]);
            if (j != null) return new int[]{j, i};
            idx.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    static char firstNonRepeating(String s) {
        Map<Character, Integer> count = new LinkedHashMap<>();
        for (char c : s.toCharArray()) count.merge(c, 1, Integer::sum);
        for (Map.Entry<Character, Integer> e : count.entrySet()) if (e.getValue() == 1) return e.getKey();
        return '_';
    }

    static boolean isAnagram(String a, String b) {
        char[] x = a.toCharArray(), y = b.toCharArray();
        Arrays.sort(x); Arrays.sort(y);
        return Arrays.equals(x, y);
    }

    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog the fox";
        Map<String, Integer> freq = new HashMap<>();
        for (String w : text.split(" ")) freq.put(w, freq.getOrDefault(w, 0) + 1);
        System.out.println("frequency: " + new TreeMap<>(freq));

        // Top 2 most frequent words (sort entries by value descending)
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));
        System.out.println("top 2: " + entries.subList(0, 2));

        System.out.println("stream version: " + Arrays.stream(text.split(" "))
                .collect(Collectors.groupingBy(w -> w, TreeMap::new, Collectors.counting())));

        System.out.println("first non-repeating in 'swiss' = " + firstNonRepeating("swiss"));
        System.out.println("twoSum([2,7,11,15], 9) = " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("listen/silent anagram? " + isAnagram("listen", "silent"));
    }
}
