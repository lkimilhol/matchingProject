package com.lkimilhol.matchingproject.member.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.domain.Nickname;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByNickname(Nickname nickname);
}