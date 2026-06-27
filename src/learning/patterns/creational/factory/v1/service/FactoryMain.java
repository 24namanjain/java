package learning.patterns.creational.factory.v1.service;

import learning.patterns.creational.factory.v1.service.notification.Notification;

public class FactoryMain {
    public static void main(String[] args) {
        System.out.println("Factory Pattern Module");

        Notification notification = NotificationFactory.createNotification("email");
        notification.notifyUser();

        notification = NotificationFactory.createNotification("sms");
        notification.notifyUser();

        notification = NotificationFactory.createNotification("whatsapp");
        notification.notifyUser();  
    }
}
