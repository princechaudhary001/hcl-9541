package org.example.notification;

public class EmailService implements NotificationService {
    @Override
    public void sendMsg(String msg) {
        System.out.println("Email: " + msg);
    }
}