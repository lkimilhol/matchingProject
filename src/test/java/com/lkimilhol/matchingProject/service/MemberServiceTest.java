package com.lkimilhol.matchingProject.service;

import com.lkimilhol.matchingProject.domain.Address;
import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.repository.AddressRepository;
import com.lkimilhol.matchingProject.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
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
                .address(address)
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build()
                ;

        //when
        Long addressId = addressRepository.save(address);
        Long memberId = memberRepository.save(member);

        //then
        Assertions.assertTrue(memberId > 0);
        Assertions.assertTrue(addressId > 0);
    }
}