package Constructorcheck;

public class check {
    public check() {
        System.out.println("Constructor called");
    }
}

class Checking {
    public static void main(String[] args) {
        check obj = new check();
    }
}