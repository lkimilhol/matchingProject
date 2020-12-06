package com.lkimilhol.matchingProject.repository.Memory;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.util.Optional;

public class MemberInfoRepositoryMemoryTest {
    MemberInfoRepositoryMemory repository = new MemberInfoRepositoryMemory();

    @Test
    public void save() {
        String nickname = "lkimilhol";
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setNickname(nickname);
        memberInfo.setAge(18);
        memberInfo.setCountry("KR");
        memberInfo.setSex("m");
        memberInfo.setInsertTime(LocalDateTime.now());
        memberInfo.setUpdateTime(LocalDateTime.now());

        repository.save(memberInfo);

        Optional<MemberInfo> result = repository.findByNickname(nickname);
        Assertions.assertEquals(nickname, result.get().getNickname());
    }
}
