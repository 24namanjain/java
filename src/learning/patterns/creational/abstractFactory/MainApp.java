package learning.patterns.creational.abstractFactory;

import learning.patterns.creational.abstractFactory.impl.UserNotificationFactory;
import learning.patterns.creational.abstractFactory.impl.AdminNotificationFactory;

public class MainApp {
    
    public static void main(String[] args) {
        System.out.println("Abstract Factory Pattern Module");
        System.out.println("--------------------------------");

        NotificationFactory notificationFactory;
        
        EmailNotification emailNotification;
        SmsNotification smsNotification;
        
        System.out.println("User Notification: ");
        notificationFactory = new UserNotificationFactory();
        emailNotification = notificationFactory.createEmailNotification();
        smsNotification = notificationFactory.createSmsNotification();

        System.out.println("User Email Notification: ");
        emailNotification.notifyUser();
        System.out.println("User SMS Notification: ");
        smsNotification.notifyUser();

        System.out.println("--------------------------------");

        System.out.println("Admin Notification: ");
        notificationFactory = new AdminNotificationFactory();
        emailNotification = notificationFactory.createEmailNotification();
        smsNotification = notificationFactory.createSmsNotification();

        System.out.println("Admin Email Notification: ");
        emailNotification.notifyUser();
        System.out.println("Admin SMS Notification: ");
        smsNotification.notifyUser();

        System.out.println("--------------------------------");
        System.out.println("End of Abstract Factory Pattern Module");
    }
}
