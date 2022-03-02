package com.example.alishevcrud.DAO;

import com.example.alishevcrud.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private List<User> userList;
    private static long PEOPLE_COUNT;

    {
        userList = new ArrayList<>();

        userList.add(new User(++PEOPLE_COUNT, "Kalleb", "Admin", (byte) 29));
        userList.add(new User(++PEOPLE_COUNT, "Alyona", "Secretary", (byte) 23));

    }

    @Override
    public List<User> index() {
        return userList;
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
    }

    @Override
    public void delete(long id) {
        userList.removeIf(p -> p.getId() == id); //Проходим по коллекции(если id == id аргумента, то User из коллекции удалится
    }
}
