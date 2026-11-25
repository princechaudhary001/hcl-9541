package org.example.fielddi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var emp = ctx.getBean(Employee.class);
            System.out.println(emp.displayAddress());
        }
    }
}