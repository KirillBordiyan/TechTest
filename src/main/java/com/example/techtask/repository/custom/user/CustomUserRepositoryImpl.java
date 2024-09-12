package com.example.techtask.repository.custom.user;

import com.example.techtask.model.User;
import com.example.techtask.model.enumiration.OrderStatus;
import com.example.techtask.model.enumiration.UserStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findUser(OrderStatus orderStatus, Integer searchYear) {

        String query = """
                SELECT u
                FROM User u
                WHERE u.id = (
                    SELECT o.userId
                    FROM Order o
                    WHERE YEAR(o.createdAt) = :year AND cast(o.orderStatus as String) = :status
                    GROUP BY o.userId
                    ORDER BY SUM(o.price * o.quantity) DESC
                    LIMIT 1
                )
                """;

        TypedQuery<User> typedQuery = em.createQuery(query, User.class);
        typedQuery.setParameter("year", searchYear);
        typedQuery.setParameter("status", orderStatus.name());

        return typedQuery.getSingleResult();
    }

    @Override
    public List<User> findUsers(OrderStatus orderStatus, Integer searchYear) {

        String query = """
                SELECT u
                FROM User u
                JOIN Order o ON o.userId = u.id
                WHERE YEAR(o.createdAt) = :paidYear AND cast(o.orderStatus as String) = :orderStatus
                """;

        TypedQuery<User> typedQuery = em.createQuery(query, User.class);
        typedQuery.setParameter("paidYear", searchYear);
        typedQuery.setParameter("orderStatus", orderStatus.name());

        return typedQuery.getResultList();
    }
}
