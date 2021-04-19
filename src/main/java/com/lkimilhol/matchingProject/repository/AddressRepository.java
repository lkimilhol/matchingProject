package com.lkimilhol.matchingProject.repository;

import com.lkimilhol.matchingProject.domain.Address;
import com.lkimilhol.matchingProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository {
    Long save(Address address);
    Address findById(Long id);
}
