package pi.lab3.chat.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pi.lab3.chat.entity.Message;
import pi.lab3.chat.repository.IMessageRepository;
import pi.lab3.chat.storage.Storage;

import java.util.TreeSet;

/**
 * Yuliia Vovk
 * 16.11.15
 */
@Repository
public class MessageRepository implements IMessageRepository {

    @Autowired
    private Storage storage;

    @Override
    public Message getLast() {
        return storage.getMessages().last();
    }

    public void add(Message message) {
        storage.getMessages().add(message);
    }

    @Override
    public TreeSet<Message> getAll() {
        return storage.getMessages();
    }
}
