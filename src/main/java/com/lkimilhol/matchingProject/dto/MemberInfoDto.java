package com.lkimilhol.matchingProject.dto;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
public class MemberInfoDto {
    private String nickname;
    private String sex;
    private int age;
    private String country;

    public MemberInfo memberInfo() {
        MemberInfo memberInfo = new MemberInfo();
        return memberInfo;
    }
}
