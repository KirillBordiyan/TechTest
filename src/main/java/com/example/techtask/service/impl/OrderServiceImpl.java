package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.OrderRepository;
import com.example.techtask.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderServiceImpl implements OrderService {

    final OrderRepository orderRepository;

    @Override
    public Order findOrder() {
        return null;
    }

    @Override
    public List<Order> findOrders() {
        return List.of();
    }

//    private SessionFactory getSessionFactory(){
//        try (SessionFactory sf = new Configuration().configure().buildSessionFactory()) {
//
//        }
//    }

}
