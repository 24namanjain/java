package patterns.creational.abstractFactory.impl;

import patterns.creational.abstractFactory.NotificationFactory;
import patterns.creational.abstractFactory.EmailNotification;
import patterns.creational.abstractFactory.SmsNotification;

public class AdminNotificationFactory implements NotificationFactory {
    
    @Override
    public EmailNotification createEmailNotification() {
        return new AdminEmailNotification();
    }

    @Override
    public SmsNotification createSmsNotification() {
        return new AdminSmsNotification();
    }
}
