package patterns.creational.factory.v1.service.notification;

public class SMSNotification implements Notification {
    
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification");
    }

}
