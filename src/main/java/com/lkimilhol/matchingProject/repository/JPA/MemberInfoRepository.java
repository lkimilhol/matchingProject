package com.lkimilhol.matchingProject.repository.JPA;


import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.repository.MemberRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class MemberInfoRepository implements MemberRepository {
    public MemberInfoRepository(EntityManager em) {
        this.em = em;
    }


    private final EntityManager em;

    @Override
    public MemberInfo save(MemberInfo memberInfo) {
        em.persist(memberInfo);
        return memberInfo;
    }

    @Override
    public Optional<MemberInfo> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberInfo> findByNickname(String name) {
        return Optional.empty();
    }

    @Override
    public List<MemberInfo> findAll() {
        return null;
    }
}
