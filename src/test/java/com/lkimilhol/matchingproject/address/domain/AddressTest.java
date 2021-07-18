package com.lkimilhol.matchingproject.address.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.matchingproject.member.domain.Member;

class AddressTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        Member member = Member.builder()
                .nickname("test")
                .age(18)
                .country("kr")
                .sex("m")
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build()
                ;

        // when
        Address address = Address.of("서울", "송파", member);

        // then
        assertThat(address).isNotNull();
        assertThat(address.getMember().getAge()).isEqualTo(18);
    }
}