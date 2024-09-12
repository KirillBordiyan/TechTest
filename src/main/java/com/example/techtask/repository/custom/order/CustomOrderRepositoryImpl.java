package com.example.techtask.repository.custom.order;

import com.example.techtask.model.Order;
import com.example.techtask.model.enumiration.UserStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CustomOrderRepositoryImpl implements CustomOrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Order findOrder() {
        String query = "SELECT o FROM Order o WHERE o.quantity > 1 ORDER BY o.createdAt DESC LIMIT 1";
        TypedQuery<Order> typedQuery = em.createQuery(query, Order.class);

        return typedQuery.getSingleResult();
    }

    @Override
    public List<Order> findOrders(UserStatus userStatus) {

        String query = """
                SELECT o
                FROM Order o
                JOIN User u ON o.userId = u.id
                WHERE cast(u.userStatus as String) = :status
                ORDER BY o.createdAt DESC
                """;

        TypedQuery<Order> typedQuery = em.createQuery(query, Order.class);
        typedQuery.setParameter("status", userStatus.name());
        return typedQuery.getResultList();
    }
}
