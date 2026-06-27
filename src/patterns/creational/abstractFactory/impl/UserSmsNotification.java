package patterns.creational.abstractFactory.impl;

import patterns.creational.abstractFactory.SmsNotification;

public class UserSmsNotification implements SmsNotification {
    
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification to user");
    }

}
