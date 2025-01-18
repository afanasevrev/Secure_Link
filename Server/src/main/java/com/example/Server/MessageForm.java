package com.example.Server;

public class MessageForm {
    private String recipient;
    private String message;
    public MessageForm() {}
    public String getRecipient() {
        return recipient;
    }
    public String getMessage() {
        return message;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
