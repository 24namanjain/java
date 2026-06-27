package patterns.creational.abstractFactory.impl;

import patterns.creational.abstractFactory.EmailNotification;

public class AdminEmailNotification implements EmailNotification {
    
    @Override
    public void notifyUser() {
        System.out.println("Sending email notification to admin");
    }

}
