
import java.util.ArrayList;
import java.util.ListIterator;

public class Array {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);

        ListIterator<Integer> it = list.listIterator();

        System.out.println("Before Update:");

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        it = list.listIterator();

        it.next();
        it.set(100);

        it.next();
        it.set(200);

        System.out.println("After Update:");

        it = list.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
