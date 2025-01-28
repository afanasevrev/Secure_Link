package com.example.Server.db;

import java.util.List;

public interface MessageService {
    String createMessage(MessageEntity entity);
    List<MessageEntity> readMessages();
    MessageEntity readMessage(Long id);
    String deleteMessage(Long id);
}
