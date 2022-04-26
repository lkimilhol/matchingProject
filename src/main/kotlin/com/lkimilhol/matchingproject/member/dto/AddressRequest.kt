package com.lkimilhol.matchingproject.member.dto

data class AddressRequest(
    val memberId: Long,
    val addressId: Long,
    val city: String,
    val district: String
)