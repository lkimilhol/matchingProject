package com.lkimilhol.matchingProject.repository.JPA;

import com.lkimilhol.matchingProject.domain.Address;
import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.repository.AddressRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class AddressRepositoryJpa implements AddressRepository {
    public AddressRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @PersistenceContext
    private final EntityManager em;

    @Override
    public Long save(Address address) {
        em.persist(address);
        return address.getId();
    }
}
