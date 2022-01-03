package com.lkimilhol.matchingproject.member.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AgeTest {

    @DisplayName("생성")
    @Test
    fun create() {
        // given
        val age = Age(10)
        // when
        // then
        assertThat(age).isEqualTo(Age(10))
    }
}