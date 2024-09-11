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
        String query = "SELECT o FROM orders o WHERE o.quantity >= 1 ORDER BY o.id DESC LIMIT 1";
        TypedQuery<Order> typedQuery = em.createQuery(query, Order.class);

        return typedQuery.getSingleResult();
    }

    @Override
    public List<Order> findOrders() {

        UserStatus active = UserStatus.ACTIVE;

        String query = """
                SELECT o
                FROM orders o
                JOIN users u USING (user_id)
                WHERE u.user_status = :userStatus
                ORDER BY o.created_at DESC
                """;

        TypedQuery<Order> typedQuery = em.createQuery(query, Order.class);
        typedQuery.setParameter("userStatus", active.name());
        return typedQuery.getResultList();
    }
}
