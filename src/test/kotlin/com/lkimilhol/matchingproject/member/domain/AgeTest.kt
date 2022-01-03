package com.lkimilhol.matchingproject.member.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AgeTest {

    @Test
    fun `생성`() {
        // given
        val age = Age(10)
        // when
        // then
        assertThat(age).isEqualTo(Age(10))
    }

    @Test
    fun `생성_실패_음수`() {
        // given
        // when
        // then
        assertThatThrownBy { Age(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}