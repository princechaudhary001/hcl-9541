package org.example.Setterdi;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Appconfig.class pass kiya gaya hai taaki Spring container ko pata chal sake[cite: 4]
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Appconfig.class); //[cite: 4]
        Employee emp = ctx.getBean(Employee.class); //[cite: 4]
        emp.displayAddress(); //[cite: 4]
        ctx.close(); //[cite: 4]
    }
}