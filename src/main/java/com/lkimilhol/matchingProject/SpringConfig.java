package com.lkimilhol.matchingProject;

import com.lkimilhol.matchingProject.domain.Address;
import com.lkimilhol.matchingProject.repository.AddressRepository;
import com.lkimilhol.matchingProject.repository.JPA.AddressRepositoryJpa;
import com.lkimilhol.matchingProject.repository.JPA.MemberRepositoryJpa;
import com.lkimilhol.matchingProject.repository.MemberRepository;
import com.lkimilhol.matchingProject.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberServiceImpl memberService() {
        return new MemberServiceImpl(memberRepository(), addressRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryJpa(em);
    }

    @Bean
    public AddressRepository addressRepository() {
        return new AddressRepositoryJpa(em);
    }
}
