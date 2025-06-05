package EmailSystem;

public class Attachment {
    int attachmentId;
    int emailId;
    String fileName;
    String filePath;

    public Attachment(int attachmentId, int emailId, String fileName, String filePath) {
        this.attachmentId = attachmentId;
        this.emailId = emailId;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public void uploadAttachment() {

    }

    public void downloadAttachment() {

    }
}
