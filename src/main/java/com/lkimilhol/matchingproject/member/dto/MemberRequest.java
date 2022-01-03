package com.lkimilhol.matchingproject.member.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingproject.member.domain.Member;

@NoArgsConstructor
@Getter
public class MemberRequest {
    private Long id;
    private String nickname;
    private String sex;
    private int age;
    private LocalDateTime insertTime;

    @Builder
    public MemberRequest(Member member) {
        this.id = member.getId();
        this.nickname = member.getNickname().toString();
        this.sex = member.getGender().toString();
        this.age = member.getAge().getAmount();
        this.insertTime = member.getInsertTime();
    }
}
