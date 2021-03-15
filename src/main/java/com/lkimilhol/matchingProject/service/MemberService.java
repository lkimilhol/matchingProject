package com.lkimilhol.matchingProject.service;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.dto.Member;
import com.lkimilhol.matchingProject.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {
    MemberInfo addMember(Member member) throws CustomException;
    List<MemberInfo> findMembers();
    Optional<MemberInfo> findOne(Long memberId);
}
