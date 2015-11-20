package pi.lab3.chat.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.lab3.chat.entity.Message;
import pi.lab3.chat.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Yuliia Vovk
 * 20.11.15
 */
@Component
public class Storage {

    @Autowired
    private TreeSet<Message> messages;

    @Autowired
    private HashMap<String, User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public TreeSet<Message> getMessages() {
        return messages;
    }
}
