package com.lkimilhol.matchingproject.member.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.address.domain.City;
import com.lkimilhol.matchingproject.address.domain.District;
import com.lkimilhol.matchingproject.address.repository.AddressRepository;
import com.lkimilhol.matchingproject.member.domain.Age;
import com.lkimilhol.matchingproject.member.domain.Country;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.dto.MemberResponse;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private MemberService memberService;

    @DisplayName("멤버 조회")
    @Test
    void getMember() {
        // given
        Member member = Member.of("test", "m", new Age(18), Country.KR);
        Address 송파 = Address.of(City.get("서울"), new District("송파"), member);
        Address 강남 = Address.of(City.get("서울"), new District("강남"), member);
        Address 서초 = Address.of(City.get("서울"), new District("서초"), member);
        // when
        when(memberRepository.findByNickname(member.getNickname())).thenReturn(Optional.of(member));
        when(addressRepository.findAddressesByMember(member)).thenReturn(Arrays.asList(송파, 강남, 서초));
        MemberResponse memberResponse = memberService.getMember(member.getNickname());
        // then
        assertThat(memberResponse.getAddresses().size()).isEqualTo(3);
    }
}
