package com.example.techtask.repository.custom.user;

import com.example.techtask.model.Order;
import com.example.techtask.model.User;

import java.util.List;

public interface CustomUserRepository {

    User findUser();
    List<User> findUsers();

}
