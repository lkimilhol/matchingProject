package com.lkimilhol.matchingproject.address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.member.domain.Member;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAddressesByMember(Member member);

}
