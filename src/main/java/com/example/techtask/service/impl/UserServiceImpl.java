package com.example.techtask.service.impl;

import com.example.techtask.model.User;
import com.example.techtask.model.enumiration.OrderStatus;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public User findUser() {
        OrderStatus status = OrderStatus.DELIVERED;
        Integer year = 2003;

        return userRepository.findUser(status, year);
    }

    @Override
    public List<User> findUsers() {
        OrderStatus status = OrderStatus.PAID;
        Integer paidYear = 2010;

        return userRepository.findUsers(status, paidYear);
    }
}
