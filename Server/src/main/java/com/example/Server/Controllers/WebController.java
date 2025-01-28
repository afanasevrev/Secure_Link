package com.example.Server.Controllers;

import com.example.Server.AESUtil;
import com.example.Server.GetMessage;
import com.example.Server.MessageForm;
import com.example.Server.db.MessageEntity;
import com.example.Server.db.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MessageEntity messageEntity = new MessageEntity();
    @Autowired
    private MessageService messageService;
    private String secretKey = "404297cd82ed1c16f1533bf2bf744fc1";
    @GetMapping("/")
    private String sendMessageEtc(Model model) {
        sendMessage(model);
        return "send_message";
    }
    @GetMapping("/sendMessage")
    private String sendMessage(Model model) {
        model.addAttribute("sendMessage", new MessageForm());
        return "send_message";
    }
    @PostMapping("/sendMessage")
    private String sendMessage(@ModelAttribute MessageForm messageForm, Model model) {
        model.addAttribute("sendMessage", messageForm);
        //String decryptedMessage = AESUtil.decrypt(messageForm.getMessage(), messageForm.getRecipient());
        //System.out.println("Posted message: " + messageForm.getMessage());
        //System.out.println("Posted decrypted message: " + decryptedMessage);
        messageEntity.setMessage(messageForm.getMessage());
        messageService.updateMessage(messageEntity, 1L);
        model.addAttribute("sendMessage", new MessageForm());
        return "send_message";
    }
    @GetMapping("/getMessage")
    private String getMessage(Model model) {
        model.addAttribute("getMessage", new GetMessage());
        return "get_message";
    }
    @PostMapping("/getMessage")
    private String getMessage(@ModelAttribute MessageForm messageForm, Model model) {
        model.addAttribute("getMessage", messageForm);
        String decryptedMessage = AESUtil.decrypt(messageForm.getMessage(), messageForm.getRecipient());
        model.addAttribute("getMessage", new MessageForm(decryptedMessage));
        return "get_message";
    }
}
