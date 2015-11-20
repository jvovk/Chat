package pi.lab3.chat.service;

import pi.lab3.chat.entity.Message;
import pi.lab3.chat.entity.User;

import java.util.TreeSet;

/**
 * Yuliia Vovk
 * 16.11.15
 */
public interface IMessageService {

    TreeSet<Message> getAllMessages();
    Message getLastMessage();
    void sendMessage(User user, String message);
}
