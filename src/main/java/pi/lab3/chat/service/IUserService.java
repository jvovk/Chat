package pi.lab3.chat.service;

import pi.lab3.chat.entity.User;

import java.util.Map;

/**
 * Yuliia Vovk
 * 16.11.15
 */
public interface IUserService {

    Map<String, Object> login(User user);
}
