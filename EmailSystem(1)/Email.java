package EmailSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Email 
{
    int emailId;
    String sender;
    String recipient;
    String subject;
    String body;
    LocalDateTime sentDate;
    boolean isDeleted;

    public Email(int emailId, String sender, String recipient, String subject, String body, LocalDateTime sentDate, boolean isDeleted)
    {
        this.emailId = emailId;
        this.sender = sender;
        this.recipient =  recipient;
        this.subject = subject;
        this.body = body;
        this.sentDate = sentDate;
        this.isDeleted = isDeleted;
    }

    public void markAsDeleted()
    {
            this.isDeleted = true;
    }

    public String getSummary()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        return  "From: " + sender +
                "\nTo: " + recipient +
                "\nSubject: " + subject +
                "\nDate: " + sentDate.format(formatter);        
    }

    //Getters
    public int getEmailId() 
    {
        return emailId;
    }

    public String getSender() 
    {
        return sender;
    }

    public String getRecipient() 
    {
        return recipient;
    }

    public String getSubject() 
    {
        return subject;
    }

    public String getBody() 
    {
        return body;
    }

    public LocalDateTime getSentDate() 
    {
        return sentDate;
    }

    public boolean isDeleted()
    {
        return isDeleted;
    }
}