package learning.patterns.creational.abstractFactory;

public interface NotificationFactory {

    EmailNotification createEmailNotification();
    SmsNotification createSmsNotification();
    
}
