package com.lkimilhol.matchingProject.repository.Memory;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.repository.MemberInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemberInfoRepositoryMemory implements MemberInfoRepository {

    private static Map<Long, MemberInfo> store = new ConcurrentHashMap<>(); //동시성 문제를 위해 ConcurrentHashMap
    private static AtomicLong seq = new AtomicLong();


    @Override
    public MemberInfo save(MemberInfo memberInfo) {
        memberInfo.setId(seq.addAndGet(1));
        store.put(seq.get(), memberInfo);
        return memberInfo;
    }

    @Override
    public Optional<MemberInfo> findById(Long id) {
        return Optional.ofNullable(store.get(seq.get()));
    }

    @Override
    public Optional<MemberInfo> findByNickname(String name) {
        return store.values().stream()
                .filter(memberInfo -> memberInfo.getNickname().equals(name))
                .findAny();
    }

    @Override
    public List<MemberInfo> findAll() {
        return new ArrayList<>(store.values());
    }
}
