package com.example.techtask.repository.custom.user;

import com.example.techtask.model.User;
import com.example.techtask.model.enumiration.OrderStatus;

import java.util.List;

public interface CustomUserRepository {

    User findUser(OrderStatus status, Integer searchYear);
    List<User> findUsers(OrderStatus status, Integer searchYear);

}
