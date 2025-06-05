package EmailSystem;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailClient {
    // SMTP Configuration and Methods
    public static void sendEmail(String host, String port, String username, String password,
            String to, String subject, String body) throws MessagingException {
        // Set SMTP properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Create session with authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            throw new MessagingException("Failed to send email: " + e.getMessage());
        }
    }

    // IMAP Configuration and Methods
    public static void readEmailsIMAP(String host, String port, String username,
            String password) throws MessagingException {
        // Set IMAP properties
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");
        props.put("mail.imaps.host", host);
        props.put("mail.imaps.port", port);

        // Create session
        Session session = Session.getInstance(props);
        Store store = session.getStore("imaps");

        try {
            // Connect to store
            store.connect(host, username, password);

            // Get inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Get messages
            Message[] messages = inbox.getMessages();
            System.out.println("Total messages: " + messages.length);

            // Process messages
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("Email #" + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Date: " + message.getSentDate());
                System.out.println("Content: " + message.getContent().toString());
                System.out.println("------------------------");
            }

            // Close connections
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            throw new MessagingException("Failed to read emails: " + e.getMessage());
        }
    }

    // POP3 Configuration and Methods
    public static void readEmailsPOP3(String host, String port, String username,
            String password) throws MessagingException {
        // Set POP3 properties
        Properties props = new Properties();
        props.put("mail.store.protocol", "pop3s");
        props.put("mail.pop3s.host", host);
        props.put("mail.pop3s.port", port);
        props.put("mail.pop3s.ssl.enable", "true");

        // Create session
        Session session = Session.getInstance(props);
        Store store = session.getStore("pop3s");

        try {
            // Connect to store
            store.connect(host, username, password);

            // Get inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Get messages
            Message[] messages = inbox.getMessages();
            System.out.println("Total messages: " + messages.length);

            // Process messages
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("Email #" + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Date: " + message.getSentDate());
                System.out.println("Content: " + message.getContent().toString());
                System.out.println("------------------------");
            }

            // Close connections
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            throw new MessagingException("Failed to read emails: " + e.getMessage());
        }
    }
}