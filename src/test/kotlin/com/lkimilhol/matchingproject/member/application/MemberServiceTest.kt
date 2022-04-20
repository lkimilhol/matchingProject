package com.lkimilhol.matchingproject.member.application

import com.lkimilhol.matchingproject.address.domain.Address
import com.lkimilhol.matchingproject.address.domain.City
import com.lkimilhol.matchingproject.address.domain.District
import com.lkimilhol.matchingproject.address.repository.AddressRepository
import com.lkimilhol.matchingproject.member.domain.*
import com.lkimilhol.matchingproject.member.repository.MemberRepository
import com.lkimilhol.matchingproject.request.CreateMember
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.runs
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

private const val NICKNAME = "닉네임"
private const val AGE = 18
private const val GENDER = "M"
private const val COUNTRY = "KR"
private const val CITY = "서울"
private const val DISTRICT = "송파"

@ExtendWith(MockitoExtension::class)
class MemberServiceTest {

    private val memberRepository = mockk<MemberRepository>()
    private val addressRepository = mockk<AddressRepository>()

    private val memberService =
        MemberService(
            memberRepository,
            addressRepository
        )

    @DisplayName("멤버 조회")
    @Test
    fun getMember() {
        // given
        val member = Member(Nickname(NICKNAME), Gender.M, Age(AGE), Country.KR)
        val 송파 = Address.of(City.get(CITY), District(DISTRICT), member)
        val 강남 = Address.of(City.get(CITY), District("강남"), member)
        val 서초 = Address.of(City.get(CITY), District("서초"), member)

        // when
        every { memberRepository.findByNickname(member.nickname) } returns Optional.of(member)
        every { addressRepository.findAddressesByMember(member) } returns listOf(송파, 강남, 서초)

        val memberResponse = memberService.getMember(member.nickname)

        // then
        memberResponse.addresses.size shouldBe 3
    }

    @Test
    fun `멤버생성`() {
        val createMember = CreateMember(
            NICKNAME,
            GENDER,
            AGE,
            COUNTRY,
            CITY,
            DISTRICT
        )

        val member = Member(Nickname(NICKNAME), Gender.M, Age(AGE), Country.KR)
        val address = Address.of(City.get(CITY), District(DISTRICT), member)

        // TODO 테스트 수정 필요
        every { memberRepository.findByNickname(member.nickname) } returns Optional.empty()
        `when` { addressRepository.save(address) }.thenReturn { address }
        `when` { memberRepository.save(member) }.thenReturn { member }

        val addMember = memberService.addMember(createMember)

        assertThat(addMember.id).isNotNull
        addMember.nickname shouldBe Nickname(NICKNAME)
        addMember.gender shouldBe Gender.M
        addMember.age shouldBe Age(AGE)
        addMember.country shouldBe Country.KR
    }
}