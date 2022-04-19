package com.lkimilhol.matchingproject.member.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class GenderTest {

    @Test
    fun `생성`() {
        // given
        val gender = Gender.valueOf("M")

        // when
        // then
        Assertions.assertThat(gender).isEqualTo(Gender.M)
    }

    @Test
    fun `생성실패`() {
        // given
        // when
        // then
        Assertions.assertThatThrownBy { Gender.valueOf("TEST") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}