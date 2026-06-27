package learning.patterns.creational.factory.v1.service;

import learning.core.DemoRunner;
import learning.core.FeatureDemo;
import learning.core.JavaLogger;
import learning.patterns.creational.factory.v1.service.notification.Notification;

public class FactoryDemo implements FeatureDemo {

    static void main() {
        DemoRunner.run(new FactoryDemo());
    }

    @Override
    public void run() {
        JavaLogger.INSTANCE.info("Factory Pattern Module");

        Notification notification = NotificationFactory.createNotification("email");
        notification.notifyUser();

        notification = NotificationFactory.createNotification("sms");
        notification.notifyUser();

        notification = NotificationFactory.createNotification("whatsapp");
        notification.notifyUser();
    }
}
