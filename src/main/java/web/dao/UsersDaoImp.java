package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsersDaoImp implements UsersDao {
    
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();

    }

    @Override
    public User getUser(long id) {

        return entityManager.find(User.class, id);

    }

    @Override
    public void saveUser(User user) {

        entityManager.persist(user);

    }

    @Override
    public void updateUser(User user, long id) {

        User updateUser = entityManager.find(User.class, id);
        updateUser.setName(user.getName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());

    }

    @Override
    public void deleteUser(long id) {

        User user = entityManager.find(User.class, id);

        if (user != null) {

            entityManager.remove(user);

        }
    }
}
