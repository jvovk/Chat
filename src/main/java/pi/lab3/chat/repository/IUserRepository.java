package pi.lab3.chat.repository;

import pi.lab3.chat.entity.User;

/**
 * Yuliia Vovk
 * 16.11.15
 */
public interface IUserRepository {

    User get(String login);
}
