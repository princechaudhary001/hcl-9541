package CollectionFrameWork;

import java.util.*;

/** Stack (legacy, LIFO) vs ArrayDeque used as a stack (recommended). */
public class StackClass {

    // Classic interview problem: balanced brackets using a stack
    static boolean isBalanced(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ("([{".indexOf(c) >= 0) st.push(c);
            else if (")]}".indexOf(c) >= 0) {
                if (st.isEmpty()) return false;
                char open = st.pop();
                if ("([{".indexOf(open) != ")]}".indexOf(c)) return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("stack = " + stack);
        System.out.println("peek = " + stack.peek());
        System.out.println("pop = " + stack.pop() + " -> " + stack);
        System.out.println("search(10) = " + stack.search(10) + " (1-based distance from top)");
        System.out.println("empty? " + stack.isEmpty());

        // Preferred in modern code: Deque
        Deque<String> dq = new ArrayDeque<>();
        dq.push("a"); dq.push("b"); dq.push("c");
        System.out.println("ArrayDeque as stack: " + dq + ", pop = " + dq.pop());

        System.out.println("{[()]} balanced? " + isBalanced("{[()]}"));
        System.out.println("{[(])} balanced? " + isBalanced("{[(])}"));

        try {
            new Stack<Integer>().pop();
        } catch (EmptyStackException e) {
            System.out.println("pop() on empty stack -> EmptyStackException");
        }
    }
}
