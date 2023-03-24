package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {

    User getUser(Long id);

    void updateUser(User user);

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

}
