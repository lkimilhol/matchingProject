package com.lkimilhol.matchingproject.member.domain

import com.lkimilhol.matchingproject.exception.EmptyException
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class NicknameNew(@Column val name: String) {
    init {
        if (name.isEmpty()) {
            throw EmptyException()
        }
    }
}