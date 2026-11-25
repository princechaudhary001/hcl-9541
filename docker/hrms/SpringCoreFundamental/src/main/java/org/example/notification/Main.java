package org.example.notification;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Appconfig.class);

        Student s1 = ctx.getBean(Student.class);
        Student s2 = ctx.getBean(Student.class);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());   // same for singleton, different for prototype
        s1.notifyStudent();

        ctx.close();   // triggers destroy() for singleton beans
    }
}