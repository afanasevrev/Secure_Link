package com.example.Server.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * Обработка запросов от клиентов
 */
@Controller
public class WebController {
    @GetMapping("/sendMessage")
    private String sendMessage() {
        return "send_message";
    }
    @PostMapping("/sendMessage")
    private String sendMessage(Model model) {
        System.out.println("Получено сообщение");
        return "Получено Post - сообщение";
    }
}
