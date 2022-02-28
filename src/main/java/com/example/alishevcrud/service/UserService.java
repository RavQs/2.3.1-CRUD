package com.example.alishevcrud.service;

import com.example.alishevcrud.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService  {
    public List<User> index();
    public User showUserById(long id);
}