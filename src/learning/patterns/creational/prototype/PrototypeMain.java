package learning.patterns.creational.prototype;

public class PrototypeMain {
    public static void main(String[] args) {
        
        EmailTemplate emailTemplate = new EmailTemplate("Hello", "This is a test email", "Thank you for your time");

        EmailTemplate clonedEmailTemplate;
        try {
            clonedEmailTemplate = (EmailTemplate) emailTemplate.clone();
        
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(emailTemplate);
        System.out.println(clonedEmailTemplate.toString());

    }
}
