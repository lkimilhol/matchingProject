package com.lkimilhol.matchingproject.request

import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateMember (
    val nickname: @NotNull @NotEmpty String,
    val gender: @NotNull @NotEmpty String,
    val age : @NotNull @Min(0) Int,
    val country: @NotNull @NotEmpty String,
    val city: @NotNull @NotEmpty String,
    val district: @NotNull @NotEmpty String
)
