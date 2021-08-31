package com.lkimilhol.matchingproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.address.domain.City;
import com.lkimilhol.matchingproject.address.domain.District;
import com.lkimilhol.matchingproject.address.repository.AddressRepository;
import com.lkimilhol.matchingproject.member.domain.Age;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    @DisplayName("멤버 생성 테스트")
    void createMember() {
        //given
        Member member = Member.of("test", "m", new Age(18), "kr");
        Address address = Address.of(City.get("서울"), new District("송파"), member);

        //when
        addressRepository.save(address);
        memberRepository.save(member);

        //then
        assertThat(address.getId()).isNotZero();
        assertThat(member.getId()).isNotZero();
    }
}