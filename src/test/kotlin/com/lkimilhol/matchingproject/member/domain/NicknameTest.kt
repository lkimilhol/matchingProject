package com.lkimilhol.matchingproject.member.domain

import com.lkimilhol.matchingproject.exception.EmptyException
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NicknameTest {
    @Test
    fun `이름은 빈값 일 수 없다`() {
        // given
        // when
        // then
        Assertions.assertThatThrownBy { Nickname("") }
            .isInstanceOf(EmptyException::class.java)
    }

    @Test
    fun `생성`() {
        // given
        val nickname = "테스트"
        // when
        val nicknameNew = Nickname(nickname)
        // then
        assertThat(nicknameNew).isEqualTo(Nickname(nickname))
    }
}