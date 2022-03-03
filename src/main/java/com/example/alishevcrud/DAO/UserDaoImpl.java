package com.example.alishevcrud.DAO;

import com.example.alishevcrud.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    private List<User> userList;
    private static long PEOPLE_COUNT;



    @Override
    public List<User> index() {
        TypedQuery<User> query = entityManager.createQuery("select u from user u", User.class);
        return query.getResultList();
    }

    @Override
    public User showUserById(long id) {
        return userList.stream().filter(user -> user.getId() == id)
                .findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        userList.add(user);
    }

    @Override
    public void update(long id, User user) {
        User userToUpdate = showUserById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setEmail(user.getEmail());
    }

    @Override
    public void delete(long id) {
        userList.removeIf(p -> p.getId() == id); //Проходим по коллекции(если id == id аргумента, то User из коллекции удалится
    }
}
