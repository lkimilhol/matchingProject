package com.lkimilhol.matchingProject;

import com.lkimilhol.matchingProject.repository.MemberInfoRepository;
import com.lkimilhol.matchingProject.repository.Memory.MemberInfoRepositoryMemory;
import com.lkimilhol.matchingProject.service.impl.MemberSerivce;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

//    private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberSerivce memberService() {
        return new MemberSerivce(memberRepository());
    }

//    @Bean
//    public MemberInfoRepository memberRepository() {
//        return new MemberInfoRepositoryJPA(em);
//    }

    @Bean
    public MemberInfoRepository memberRepository() {
        return new MemberInfoRepositoryMemory();
    }

}
