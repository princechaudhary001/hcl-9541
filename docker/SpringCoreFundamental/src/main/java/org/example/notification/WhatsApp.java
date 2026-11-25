package org.example.notification;

public class WhatsApp implements NotificationService {
    @Override
    public void sendMsg(String msg) {
        System.out.println("WhatsApp: " + msg);
    }
}