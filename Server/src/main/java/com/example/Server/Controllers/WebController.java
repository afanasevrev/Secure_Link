package com.example.Server.Controllers;

import com.example.Server.AESUtil;
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
    private String secretKey = "404297cd82ed1c16f1533bf2bf744fc1";
    @GetMapping("/sendMessage")
    private String sendMessage(Model model) {
        model.addAttribute("sendMessage", new MessageForm());
        return "send_message";
    }
    @PostMapping("/sendMessage")
    private String sendMessage(@ModelAttribute MessageForm messageForm, Model model) {
        model.addAttribute("sendMessage", messageForm);
        String decryptedMessage = AESUtil.decrypt(messageForm.getMessage(), secretKey);
        System.out.println("Posted message: " + messageForm.getMessage());
        System.out.println("Posted decrypted message: " + decryptedMessage);
        model.addAttribute("sendMessage", new MessageForm());
        return "send_message";
    }
}
