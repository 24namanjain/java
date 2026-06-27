package learning.patterns.creational.abstractFactory.impl;

import learning.patterns.creational.abstractFactory.SmsNotification;

public class UserSmsNotification implements SmsNotification {
    
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification to user");
    }

}
