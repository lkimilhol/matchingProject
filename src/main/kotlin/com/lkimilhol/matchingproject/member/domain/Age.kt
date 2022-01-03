package com.lkimilhol.matchingproject.member.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Age(@Column val amount: Int) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("음수 일 수 없습니다")
        }
    }
}