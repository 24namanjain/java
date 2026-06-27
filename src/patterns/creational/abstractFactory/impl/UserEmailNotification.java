package patterns.creational.abstractFactory.impl;

import patterns.creational.abstractFactory.EmailNotification;

public class UserEmailNotification implements EmailNotification {
    
    @Override
    public void notifyUser() {
        System.out.println("Sending email notification to user");
    }

}
