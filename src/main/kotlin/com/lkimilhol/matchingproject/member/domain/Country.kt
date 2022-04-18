package com.lkimilhol.matchingproject.member.domain

import com.lkimilhol.matchingproject.exception.NotFoundCountryException

enum class Country(val country: String) {
    KR("KR"),
    JA("JA");

    @Override
    fun valueOf():Country {
        when (name) {
            "KR" -> return KR
            "JA" -> return JA
        }
        throw NotFoundCountryException()
    }
}