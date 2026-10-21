package org.example.notification;

import org.springframework.context.annotation.*;

@Configuration
public class Appconfig {

    @Bean
    @Primary
    public NotificationService emailService() {
        return new EmailService();
    }

    @Bean
    public NotificationService whatsApp() {
        return new WhatsApp();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("singleton")   // try "prototype" and compare the hash codes
    public Student student(NotificationService notificationService) {
        return new Student(notificationService);   // gets the @Primary one (email)
    }
}