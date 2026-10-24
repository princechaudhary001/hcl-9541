package org.example.notification;

public class Student {
    private final NotificationService notificationService;

    public Student(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyStudent() {
        notificationService.sendMsg("Your assessment is scheduled");
    }

    public void init() {
        System.out.println("Object Created");
    }

    public void destroy() {
        System.out.println("Object destroyed");
    }
}