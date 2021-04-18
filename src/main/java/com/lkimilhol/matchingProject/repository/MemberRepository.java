package com.lkimilhol.matchingProject.repository;


import com.lkimilhol.matchingProject.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByNickname(String name);
    List<Member> findAll();
}