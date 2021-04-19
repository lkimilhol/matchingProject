package com.lkimilhol.matchingProject.dto;


import com.lkimilhol.matchingProject.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberDto {
    Member member;

    @Builder
    protected MemberDto(Member member) {
        this.member = member;
    }
}
