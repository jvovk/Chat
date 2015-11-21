package pi.lab3.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pi.lab3.chat.entity.User;
import pi.lab3.chat.repository.IUserRepository;
import pi.lab3.chat.service.IUserService;
import pi.lab3.chat.util.MD5Encoder;

import java.util.HashMap;
import java.util.Map;

/**
 * Yuliia Vovk
 * 16.11.15
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Map<String, Object> login(User user) {
        User u = userRepository.get(user.getLogin());

        Map<String, Object> response = new HashMap<>();

        if (u == null) {
            response.put("error", "No user found with such login!");
        } else if (!MD5Encoder.encrypt(user.getPasswordHash()).startsWith(u.getPasswordHash())) {
            response.put("error", "Incorrect password! Please, check and try again!");
        } else {
            response.put("user", u);
            response.put("redirect", "/chat");
        }
        return response;
    }
}
