package com.example.techtask.repository.custom.order;

import com.example.techtask.model.Order;
import com.example.techtask.model.enumiration.UserStatus;

import java.util.List;

public interface CustomOrderRepository {

    Order findOrder();

    List<Order> findOrders(UserStatus status);

}
