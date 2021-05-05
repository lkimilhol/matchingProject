package com.lkimilhol.matchingProject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingProject.domain.Member;

@NoArgsConstructor
@Getter
public class MemberDto {
    private Long id;
    private String nickname;
    private String sex;
    private int age;

    @Builder
    protected MemberDto(Member member) {
        this.id = member.getId();
        this.nickname = member.getNickname();
        this.sex = member.getSex();
        this.age = member.getAge();
    }
}
