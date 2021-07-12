package com.lkimilhol.matchingProject.member.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lkimilhol.matchingProject.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}