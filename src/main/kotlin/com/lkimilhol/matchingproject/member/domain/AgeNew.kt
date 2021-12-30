package com.lkimilhol.matchingproject.member.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class AgeNew(age : Int) {

    @Column(name = "age")
    val amount = age

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AgeNew

        if (amount != other.amount) return false

        return true
    }

    override fun hashCode(): Int {
        return amount
    }
}