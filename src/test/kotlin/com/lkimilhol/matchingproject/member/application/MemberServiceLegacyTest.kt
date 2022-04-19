package com.lkimilhol.matchingproject.member.application

import com.lkimilhol.matchingproject.address.domain.Address
import com.lkimilhol.matchingproject.address.domain.City
import com.lkimilhol.matchingproject.address.domain.District
import com.lkimilhol.matchingproject.address.repository.AddressRepository
import com.lkimilhol.matchingproject.member.domain.*
import com.lkimilhol.matchingproject.member.repository.MemberRepository
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class MemberServiceLegacyTest {

    private val memberRepository = mockk<MemberRepository>()
    private val addressRepository = mockk<AddressRepository>()

    private val memberServiceLegacy =
        MemberServiceLegacy(
            memberRepository,
            addressRepository
        )

    @DisplayName("멤버 조회")
    @Test
    fun getMember() {
        // given
        val member = Member(Nickname("test"), Gender.M, Age(18), Country.KR)
        val 송파 = Address.of(City.get("서울"), District("송파"), member)
        val 강남 = Address.of(City.get("서울"), District("강남"), member)
        val 서초 = Address.of(City.get("서울"), District("서초"), member)

        // when
        every { memberRepository.findByNickname(member.nickname) } returns Optional.of(member)
        every { addressRepository.findAddressesByMember(member) } returns listOf(송파, 강남, 서초)

        val memberResponse = memberServiceLegacy.getMember(member.nickname)

        // then
        memberResponse.addresses.size shouldBe 3
    }
}