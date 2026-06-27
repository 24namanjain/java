package learning.patterns.creational.abstractFactory.impl;

import learning.patterns.creational.abstractFactory.NotificationFactory;
import learning.patterns.creational.abstractFactory.EmailNotification;
import learning.patterns.creational.abstractFactory.SmsNotification;

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
