package pi.lab3.chat.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pi.lab3.chat.entity.User;
import pi.lab3.chat.repository.IUserRepository;
import pi.lab3.chat.storage.Storage;

/**
 * Yuliia Vovk
 * 16.11.15
 */
@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private Storage storage;

    public User get(String login) {
        return storage.getUsers().get(login);
    }
}
