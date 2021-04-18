package com.lkimilhol.matchingProject.repository.JPA;


import com.lkimilhol.matchingProject.domain.Member;
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
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByNickname(String nickname) {
        List<Member> result = em.createQuery("select m from Member m where m.nickname = :nickname", Member.class)
                .setParameter("nickname", nickname)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
