package com.example.alishevcrud.DAO;

import com.example.alishevcrud.model.User;

import java.util.List;

public interface UserDao {
     List<User> index();
     User showUserById(long id);
     void save(User user);
}
