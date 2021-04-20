package com.lkimilhol.matchingProject.repository.JPA;

import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ShopRepositoryJpa implements ShopRepository {
    private final EntityManager em;

    @Override
    public Long save(Shop shop) {
        em.persist(shop);
        return shop.getId();
    }

    @Override
    public Shop findById(Long id) {
        return em.find(Shop.class, id);
    }

    @Override
    public Optional<Shop> findByName(String name) {
        List<Shop> result = em.createQuery("select s from Shop s where s.name = :name", Shop.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Shop> findAll() {
        return null;
    }
}
