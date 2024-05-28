package web.service;

import web.models.User;

import java.util.List;

public interface UsersServise {

    public List<User> getAllUsers();

    public User getUser(long id);

    public void saveUser(User user);

    public void updateUser(User user, long id);

    public void deleteUser(long id);
}
