package com.lkimilhol.matchingproject.member.domain

import com.lkimilhol.matchingproject.exception.NotFoundCountryException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CountryTest {

    @Test
    fun `생성`() {
        // given
        val country = Country.valueOf("KR")

        // when
        // then
        Assertions.assertThat(country).isEqualTo(Country.KR)
    }

    @Test
    fun `생성실패`() {
        // given
        // when
        // then
        Assertions.assertThatThrownBy { Country.valueOf("TEST") }
            .isInstanceOf(IllegalArgumentException::class.java)

    }
}