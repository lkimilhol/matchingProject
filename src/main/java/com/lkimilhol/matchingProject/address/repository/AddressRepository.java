package com.lkimilhol.matchingProject.address.repository;

import com.lkimilhol.matchingProject.address.domain.Address;

public interface AddressRepository {
    Long save(Address address);
    Address findById(Long id);
}
