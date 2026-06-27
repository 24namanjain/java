package patterns.creational.abstractFactory.impl;

import patterns.creational.abstractFactory.SmsNotification;

public class AdminSmsNotification implements SmsNotification {
    
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification to admin");
    }

}
