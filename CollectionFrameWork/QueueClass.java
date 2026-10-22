package CollectionFrameWork;
import java.util.*;

public class QueueClass {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.offer(4);
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
        q.offer(1);
        System.out.println(q);
    }
}