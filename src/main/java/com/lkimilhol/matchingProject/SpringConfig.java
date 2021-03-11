package com.lkimilhol.matchingProject;

import com.lkimilhol.matchingProject.repository.JPA.MemberInfoRepositoryJPA;
import com.lkimilhol.matchingProject.repository.MemberInfoRepository;
import com.lkimilhol.matchingProject.service.impl.MemberSerivce;
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
    public MemberSerivce memberService() {
        return new MemberSerivce(memberRepository());
    }

    @Bean
    public MemberInfoRepository memberRepository() {
        return new MemberInfoRepositoryJPA(em);
    }

}
