package com.example.Server.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Обработка запросов от клиентов
 */
@Controller
public class WebController {
    @GetMapping("/sendMessage")
    private String sendMessage() {
        return "send_message";
    }
}
