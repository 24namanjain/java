package learning.patterns.creational.abstractFactory.impl;

import learning.patterns.creational.abstractFactory.NotificationFactory;
import learning.patterns.creational.abstractFactory.EmailNotification;
import learning.patterns.creational.abstractFactory.SmsNotification;

public class UserNotificationFactory implements NotificationFactory {
    
    @Override
    public EmailNotification createEmailNotification() {
        return new UserEmailNotification();
    }

    @Override
    public SmsNotification createSmsNotification() {
        return new UserSmsNotification();
    }
}
