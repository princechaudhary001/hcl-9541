package OOPS;

public class Main {
    public static void display(){
        System.out.println("In Parent");
    }
}


class child extends Main{
    public static void main(String[] args) {
        Main obj = new child();
        obj.display();
    }
    public static void display(){
        System.out.println("in child");

    }
}
