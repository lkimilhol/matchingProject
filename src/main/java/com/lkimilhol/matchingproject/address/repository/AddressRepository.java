package com.lkimilhol.matchingproject.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkimilhol.matchingproject.address.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
