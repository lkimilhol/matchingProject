package com.lkimilhol.matchingProject.repository.JPA;


import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberInfoRepository implements MemberRepository {

    @Override
    public MemberInfo save(MemberInfo memberInfo) {
        return null;
    }

    @Override
    public Optional<MemberInfo> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberInfo> findByNickname(String name) {
        return Optional.empty();
    }

    @Override
    public List<MemberInfo> findAll() {
        return null;
    }
}
