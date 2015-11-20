package pi.lab3.chat.repository;

import pi.lab3.chat.entity.Message;

import java.util.TreeSet;

/**
 * Yuliia Vovk
 * 16.11.15
 */
public interface IMessageRepository {

    Message getLast();
    void add(Message message);
    TreeSet<Message> getAll();
}
