package com.lkimilhol.matchingProject.service;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {
    Long addMember(MemberInfo memberInfo);
    List<MemberInfo> findMembers();
    Optional<MemberInfo> findOne(Long memberId);
}
