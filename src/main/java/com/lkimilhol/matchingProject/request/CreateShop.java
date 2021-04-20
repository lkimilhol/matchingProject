package com.lkimilhol.matchingProject.request;

import com.lkimilhol.matchingProject.common.CategoryEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateShop {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String district;
}
