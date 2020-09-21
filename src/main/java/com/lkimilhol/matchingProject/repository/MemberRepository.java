package com.lkimilhol.matchingProject.repository;


import com.lkimilhol.matchingProject.domain.MemberInfo;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberInfo save(MemberInfo memberInfo);
    Optional<MemberInfo> findById(Long id);
    Optional<MemberInfo> findByNickname(String name);
    List<MemberInfo> findAll();
}