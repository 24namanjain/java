package patterns.creational.factory.v1.service;

import patterns.creational.factory.v1.service.notification.EmailNotification;
import patterns.creational.factory.v1.service.notification.Notification;
import patterns.creational.factory.v1.service.notification.SMSNotification;
import patterns.creational.factory.v1.service.notification.WhatsappNotification;

public class NotificationFactory {
    
    public static Notification createNotification(String notificationType) {
        if (notificationType == null || notificationType.isEmpty()) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }
        
        System.out.println("Creating notification object for type: " + notificationType);
        
        return switch (notificationType.toLowerCase()) {
            case "email" -> 
                 new EmailNotification();
            case "sms" ->
                 new SMSNotification();
            case "whatsapp" ->
                 new WhatsappNotification();
            default ->
                 throw new IllegalArgumentException("Invalid notification type: " + notificationType);
        };
    }
    
}
