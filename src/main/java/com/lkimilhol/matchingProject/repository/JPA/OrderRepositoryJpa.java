package com.lkimilhol.matchingProject.repository.JPA;

import com.lkimilhol.matchingProject.domain.Order;
import com.lkimilhol.matchingProject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class OrderRepositoryJpa implements OrderRepository {
    private final EntityManager em;

    @Override
    public Long save(Order order) {
        em.persist(order);
        return order.getId();
    }

    @Override
    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("select o from orders o", Order.class).getResultList();
    }
}
