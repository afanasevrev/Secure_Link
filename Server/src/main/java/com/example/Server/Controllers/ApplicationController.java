package com.example.Server.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
public class ApplicationController {
    @PostMapping("/sendMessage")
    private String sendMessage(@RequestBody Map<String, String> request) {
        String recipient = request.get("recipient");
        String message = request.get("message");
        System.out.println("Получатель: " + recipient);
        System.out.println("Сообщение: " + message);
        return "Сообщение успешно отправлено!";
    }
}
