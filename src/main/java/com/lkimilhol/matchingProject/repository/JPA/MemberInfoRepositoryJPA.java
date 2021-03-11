package com.lkimilhol.matchingProject.repository.JPA;


import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.repository.MemberInfoRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberInfoRepositoryJPA implements MemberInfoRepository {
    public MemberInfoRepositoryJPA(EntityManager em) {
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
    public Optional<MemberInfo> findByNickname(String nickname) {
        List<MemberInfo> result = em.createQuery("select m from MemberInfo m where m.nickname = :nickname", MemberInfo.class)
                .setParameter("nickname", nickname)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<MemberInfo> findAll() {
        return null;
    }
}
