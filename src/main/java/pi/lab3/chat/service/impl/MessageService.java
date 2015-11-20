package pi.lab3.chat.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pi.lab3.chat.entity.Message;
import pi.lab3.chat.entity.User;
import pi.lab3.chat.repository.IMessageRepository;
import pi.lab3.chat.service.IMessageService;

import java.util.TreeSet;

/**
 * Yuliia Vovk
 * 16.11.15
 */
@Service
public class MessageService implements IMessageService {

    @Autowired
    private IMessageRepository messageRepository;

    @Override
    public TreeSet<Message> getAllMessages() {
        return messageRepository.getAll();
    }

    @Override
    public Message getLastMessage() {
        return messageRepository.getLast();
    }

    @Override
    public synchronized void sendMessage(User user, String message) {
        Message completeMessage = new Message();
        completeMessage.setSender(user);
        completeMessage.setDate(DateTime.now().toDate());
        completeMessage.setMessage(message);
        messageRepository.add(completeMessage);
    }
}
