package learning.patterns.creational.prototype;

import learning.core.DemoRunner;
import learning.core.FeatureDemo;
import learning.core.JavaLogger;
import learning.core.exception.FeatureException;

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
