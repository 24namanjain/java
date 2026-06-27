package patterns.creational.prototype;

import core.DemoRunner;
import core.FeatureDemo;
import core.JavaLogger;
import core.exception.FeatureException;

public class PrototypeDemo implements FeatureDemo {

    static void main() {
        DemoRunner.run(new PrototypeDemo());
    }

    @Override
    public void run() {
        EmailTemplate emailTemplate = new EmailTemplate("Hello", "This is a test email", "Thank you for your time");

        EmailTemplate clonedEmailTemplate;
        try {
            clonedEmailTemplate = (EmailTemplate) emailTemplate.clone();
        } catch (CloneNotSupportedException e) {
            throw new FeatureException("Clone not supported: " + e.getMessage());
        }

        JavaLogger.INSTANCE.info(emailTemplate.toString());
        JavaLogger.INSTANCE.info(clonedEmailTemplate.toString());
    }
}
