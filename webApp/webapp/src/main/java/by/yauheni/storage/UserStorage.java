package by.yauheni.storage;

import by.yauheni.domain.User;

import java.util.List;

public interface UserStorage {
    boolean save(User user);

    User remove(long id);
    User remove(String login);

    String updateName(String name, long id);
    String updatePassword(String pass, long id);

    List<User> getAll();
    List<User> getAllByName(String name);
    User getUserById(long id);
    User getUserByLogin(String login);

    boolean contains(User user);
    boolean contains(long id);
    boolean contains(String login);
}
