package com.lkimilhol.matchingProject.service;

import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.request.CreateMember;
import com.lkimilhol.matchingProject.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {
    Member addMember(CreateMember createMember) throws CustomException;

    List<Member> findMembers();

    Optional<Member> findById(Long memberId);

    Optional<Member> findByNickname(String nickname);
}
