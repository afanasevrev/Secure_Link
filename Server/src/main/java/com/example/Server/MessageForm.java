package com.example.Server;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MessageForm {
    private String recipient;
    private String message;
    public MessageForm() {}
}
