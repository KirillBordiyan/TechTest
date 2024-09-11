package com.example.techtask.repository.custom.user;

import com.example.techtask.model.User;
import com.example.techtask.model.enumiration.OrderStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findUser() {
        OrderStatus status = OrderStatus.DELIVERED;
        Integer year = 2003;

        String query = """
                SELECT u
                FROM users u
                WHERE u.id = (
                    SELECT o.user_id
                    FROM orders o
                    WHERE YEAR(o.created_at) = :year AND o.order_status = :status
                    GROUP BY o.user_id
                    ORDER BY SUM(o.price * o.quantity) DESC
                    LIMIT 1
                )
                """;

        TypedQuery<User> typedQuery = em.createQuery(query, User.class);
        typedQuery.setParameter("year", year);
        typedQuery.setParameter("status", status);

        return typedQuery.getSingleResult();

    }

    @Override
    public List<User> findUsers() {

    }
}
