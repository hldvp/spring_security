package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(long id);
    public void createUser(User user);
    public void updateUser(User user);
    public void deleteUser(long id);
    public User getUserByUsername(String username);
}
