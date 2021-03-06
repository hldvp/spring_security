package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(long id);
    public void createUser(User user);
    public void updateUser(User user);
    public void deleteUser(long id);
    public User getUserByUsername(String username);
}
