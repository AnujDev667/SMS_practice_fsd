package com.designpatterns.singleton;

public class EmailUtilityAzure extends EmailUtility {
    private static final EmailUtilityAzure emailUtilityAzure = new EmailUtilityAzure();

    // Private constructor
    private EmailUtilityAzure() {
        super(""); // Ensure to pass the necessary argument if required by the superclass constructor
    }

    // Singleton instance getter
    public static EmailUtilityAzure getInstance() {
        return emailUtilityAzure;
    }

    // Corrected sendMail method
    public void sendMail() {
        System.out.println("Connection details of server 2");
        System.out.println("Mail sent with the following info:");
        System.out.println("From Email: " + fromEmail);
        System.out.println("To Email: " + toEmail);
        System.out.println("Subject: " + subject);
        System.out.println("Email Body: " + content);
    }
}
