package patterns.creational.factory.v1.service.notification;

public class WhatsappNotification implements Notification {
    
    @Override
    public void notifyUser() {
        System.out.println("Sending WhatsApp notification");
    }
}
