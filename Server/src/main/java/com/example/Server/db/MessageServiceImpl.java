package com.example.Server.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public String createMessage(MessageEntity entity) {
        messageRepository.save(entity);
        return "Сообщение сохранено";
    }
    @Override
    public List<MessageEntity> readMessages() {
        return messageRepository.findAll();
    }
    @Override
    public MessageEntity readMessage(Long id) {
        return messageRepository.findById(id).get();
    }
    @Override
    public String deleteMessage(Long id) {
        messageRepository.deleteById(id);
        return "Сообщение удалено";
    }

    @Override
    public String updateMessage(MessageEntity entity, Long id) {
        MessageEntity messageEntity = messageRepository.findById(id).get();
        messageEntity.setMessage(entity.getMessage());
        messageRepository.save(messageEntity);
        return "Сообщение обновлено";
    }
}
