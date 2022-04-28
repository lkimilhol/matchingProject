package com.lkimilhol.matchingproject.member.dto

data class AddressResponse(
    val addressId: Long?,
    val memberId: Long?,
    val city: String,
    val district: String,
)