package learning.patterns.creational.abstractFactory;

import learning.core.DemoRunner;
import learning.core.FeatureDemo;
import learning.core.JavaLogger;
import learning.patterns.creational.abstractFactory.impl.AdminNotificationFactory;
import learning.patterns.creational.abstractFactory.impl.UserNotificationFactory;

public class AbstractFactoryDemo implements FeatureDemo {

    static void main() {
        DemoRunner.run(new AbstractFactoryDemo());
    }

    @Override
    public void run() {
        JavaLogger.INSTANCE.info("Abstract Factory Pattern Module");
        JavaLogger.INSTANCE.info("--------------------------------");

        NotificationFactory notificationFactory;

        EmailNotification emailNotification;
        SmsNotification smsNotification;

        JavaLogger.INSTANCE.info("User Notification: ");
        notificationFactory = new UserNotificationFactory();
        emailNotification = notificationFactory.createEmailNotification();
        smsNotification = notificationFactory.createSmsNotification();

        JavaLogger.INSTANCE.info("User Email Notification: ");
        emailNotification.notifyUser();
        JavaLogger.INSTANCE.info("User SMS Notification: ");
        smsNotification.notifyUser();

        JavaLogger.INSTANCE.info("--------------------------------");

        JavaLogger.INSTANCE.info("Admin Notification: ");
        notificationFactory = new AdminNotificationFactory();
        emailNotification = notificationFactory.createEmailNotification();
        smsNotification = notificationFactory.createSmsNotification();

        JavaLogger.INSTANCE.info("Admin Email Notification: ");
        emailNotification.notifyUser();
        JavaLogger.INSTANCE.info("Admin SMS Notification: ");
        smsNotification.notifyUser();

        JavaLogger.INSTANCE.info("--------------------------------");
        JavaLogger.INSTANCE.info("End of Abstract Factory Pattern Module");
    }
}
