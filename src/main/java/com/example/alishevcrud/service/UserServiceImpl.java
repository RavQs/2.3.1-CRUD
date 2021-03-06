package com.example.alishevcrud.service;

import com.example.alishevcrud.DAO.UserDao;
import com.example.alishevcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User showUserById(long id) {
        return userDao.showUserById(id);
    }

    public void save(User user){
        userDao.save(user);
    }

    @Override
    public void update(long id, User user) {
        userDao.update(id,user);
    }

    public void delete(long id){
        userDao.delete(id);
    }
}
