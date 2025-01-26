package com.example.Server;

public class GetMessage {
    private String recipient;
    private String message;
    public GetMessage() {}
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
