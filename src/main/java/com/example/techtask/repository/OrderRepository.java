package com.example.techtask.repository;

import com.example.techtask.model.Order;
import com.example.techtask.repository.custom.order.CustomOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, CustomOrderRepository {
}
