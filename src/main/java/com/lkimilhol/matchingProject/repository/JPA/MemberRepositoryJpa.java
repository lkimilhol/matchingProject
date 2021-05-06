package com.lkimilhol.matchingProject.repository.JPA;


import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryJpa implements MemberRepository {

    private final EntityManager em;

    @Override
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    @Override
    public Member findById(Long id) {
        return em.find(Member.class, id);
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
