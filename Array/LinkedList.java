package Array;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Insert at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Insert at a given position (0-based)
    void insertAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node temp = head;

        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete from beginning
    void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
    }

    // Delete from end
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    // Delete by value (first occurrence)
    void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Search
    boolean search(int value) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // Update at a given position (0-based)
    void update(int position, int value) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }

        Node temp = head;

        for (int i = 0; temp != null && i < position; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        temp.data = value;
    }

    // Display
    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Count nodes
    int size() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Check empty
    boolean isEmpty() {
        return head == null;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.insertAtEnd(30);
        list.insertAtPosition(25, 2);
        list.display();

        list.update(1, 15);
        list.display();

        System.out.println("Search 30: " + list.search(30));
        System.out.println("Size: " + list.size());

        list.deleteAtBeginning();
        list.deleteAtEnd();
        list.deleteByValue(25);
        list.display();

        System.out.println("Is Empty: " + list.isEmpty());
    }
}
