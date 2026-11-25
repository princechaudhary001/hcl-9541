package Constructorcheck;

public class Constructoroverloading {

    String name;
    int rollno;

    public Constructoroverloading() {
        System.out.println("this is no arg consructor");
    }

    public Constructoroverloading(int rollno) {
        this.rollno = rollno;
        System.out.println("this is rollno consructor");
    }
    public Constructoroverloading(String name) {
        this.name = name;
        System.out.println("this is Name consructor");
    }

    Constructoroverloading(String name, int rollno){
        this.name = name;
        this.rollno = rollno;
    }


    public static void main(String[] args) {
        Constructoroverloading Aviral = new Constructoroverloading("Aviral");
    }
}
