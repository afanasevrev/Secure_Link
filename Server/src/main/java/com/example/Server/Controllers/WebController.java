package com.example.Server.Controllers;

import com.example.Server.MessageForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * Обработка запросов от клиентов
 */
@Controller
public class WebController {
    @GetMapping("/sendMessage")
    private String sendMessage(Model model) {
        model.addAttribute("sendMessage", new MessageForm());
        return "send_message";
    }
    @PostMapping("/sendMessage")
    private String sendMessage(@ModelAttribute MessageForm messageForm, Model model) {
        model.addAttribute("sendMessage", messageForm);
        System.out.println("Posted message " + messageForm.getMessage());
        return "send_message";
    }
}
