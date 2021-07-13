package com.lkimilhol.matchingproject.service;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.address.repository.AddressRepository;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void createMember() {
        //given
        Address address = Address.builder()
                .city("서울")
                .district("송파")
                .build();

        Member member = Member.builder()
                .nickname("test")
                .age(18)
                .country("kr")
                .sex("m")
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build()
                ;

        //when
        addressRepository.save(address);
        memberRepository.save(member);

        //then
        assertThat(address.getId()).isNotZero();
        assertThat(member.getId()).isNotZero();
    }
}