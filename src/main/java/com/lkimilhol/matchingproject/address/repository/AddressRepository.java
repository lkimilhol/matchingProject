package com.lkimilhol.matchingproject.address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.member.domain.Member;

@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAddressesByMember(Member member);

}
