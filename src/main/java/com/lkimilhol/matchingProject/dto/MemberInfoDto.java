package com.lkimilhol.matchingProject.dto;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class MemberInfoDto {
    @NotNull
    private String nickname;
    @NotNull
    private String sex;
    @NotNull
    private int age;
    @NotNull
    private String country;

    public MemberInfo dto() {
        return MemberInfo.builder()
                .nickname(this.nickname)
                .sex(this.sex)
                .age(this.age)
                .country(this.country)
                .build();
    }
}
