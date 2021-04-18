package com.lkimilhol.matchingProject.repository.JPA;

import com.lkimilhol.matchingProject.domain.Address;
import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.repository.AddressRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class AddressRepositoryJpa implements AddressRepository {
    public AddressRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    private final EntityManager em;

    @Override
    public void save(Address address) {
        em.persist(address);
    }

}
