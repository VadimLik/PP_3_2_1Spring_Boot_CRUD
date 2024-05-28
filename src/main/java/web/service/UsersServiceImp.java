package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UsersDao;
import web.models.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UsersServiceImp implements UsersServise{

    private final UsersDao usersDao;

    @Autowired
    public UsersServiceImp(UsersDao usersDao) {

        this.usersDao = usersDao;

    }


    @Override
    public List<User> getAllUsers() {

        return usersDao.getAllUsers();

    }

    @Override
    public User getUser(long id) {

        return usersDao.getUser(id);

    }

    @Transactional
    public void saveUser(User user) {

        usersDao.saveUser(user);

    }

    @Transactional
    @Override
    public void updateUser(User user, long id) {

        usersDao.updateUser(user, id);

    }


    @Transactional
    @Override
    public void deleteUser(long id) {

        usersDao.deleteUser(id);

    }
}
