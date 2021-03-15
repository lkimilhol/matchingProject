package com.lkimilhol.matchingProject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Member {
    @NotNull
    @NotEmpty
    private String nickname;

    @NotNull
    @NotEmpty
    private String sex;

    @NotNull
    @Min(0)
    private int age;

    @NotNull
    @NotEmpty
    private String country;
}
