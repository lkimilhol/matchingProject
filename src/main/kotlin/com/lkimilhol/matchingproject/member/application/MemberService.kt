package com.lkimilhol.matchingproject.member.application

import com.lkimilhol.matchingproject.address.domain.Address
import com.lkimilhol.matchingproject.address.domain.City
import com.lkimilhol.matchingproject.address.domain.District
import com.lkimilhol.matchingproject.address.repository.AddressRepository
import com.lkimilhol.matchingproject.exception.NicknameAlreadyExistsException
import com.lkimilhol.matchingproject.exception.NotFoundMemberException
import com.lkimilhol.matchingproject.member.domain.*
import com.lkimilhol.matchingproject.member.dto.MemberResponse
import com.lkimilhol.matchingproject.member.repository.MemberRepository
import com.lkimilhol.matchingproject.request.CreateMember
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class MemberService(val memberRepository: MemberRepository, val addressRepository: AddressRepository) {

    @Transactional
    fun addMember(createMember: CreateMember): Member {
        checkDuplicateMember(createMember)

        val member = Member(
            Nickname(createMember.nickname),
            Gender.valueOf(createMember.gender),
            Age(createMember.age),
            Country.valueOf(createMember.country)
        )

        val address = Address.of(City.get(createMember.city), District(createMember.district), member)

        addressRepository.save(address)
        memberRepository.save(member)

        return member
    }

    fun findByNickname(nickname: Nickname): Optional<Member> {
        return memberRepository.findByNickname(nickname)
    }

    fun getMember(nickname: Nickname): MemberResponse {
        val member = findByNickname(nickname).orElseThrow { NotFoundMemberException() }
        val addresses = addressRepository.findAddressesByMember(member)
        return MemberResponse.of(member, addresses)
    }

    private fun checkDuplicateMember(createMember: CreateMember) {
        val memberInfo: Optional<Member> = findByNickname(Nickname(createMember.nickname))
        if (memberInfo.isPresent) {
            throw NicknameAlreadyExistsException()
        }
    }
}