package com.lkimilhol.matchingProject.repository.JPA;

import com.lkimilhol.matchingProject.domain.Address;
import com.lkimilhol.matchingProject.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class AddressRepositoryJpa implements AddressRepository {

    private final EntityManager em;

    @Override
    public Long save(Address address) {
        em.persist(address);
        return address.getId();
    }

    @Override
    public Address findById(Long id) {
        return em.find(Address.class, id);
    }
}
