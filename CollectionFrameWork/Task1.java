package CollectionFrameWork;
import java.util.*;

class Student {
    String name;
    int rollNo, age, marks;

    Student(String name, int rollNo, int age, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return name + " " + rollNo + " " + age + " " + marks;
    }
}

class Task1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter name, roll no, age, marks:");
            String name = sc.next();
            int rollNo = sc.nextInt();
            int age = sc.nextInt();
            int marks = sc.nextInt();

            list.add(new Student(name, rollNo, age, marks));
        }

        list.sort(Comparator.comparingInt(s -> s.age));
        System.out.println("\nSorted by Age:");
        for (Student s : list)
            System.out.println(s);

        list.sort(Comparator.comparingInt(s -> s.marks));
        System.out.println("\nSorted by Marks:");
        for (Student s : list)
            System.out.println(s);
    }
}