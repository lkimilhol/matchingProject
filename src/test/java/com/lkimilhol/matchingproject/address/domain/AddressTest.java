package com.lkimilhol.matchingproject.address.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.dto.AddressRequest;

class AddressTest {

    private Member member;

    @BeforeEach
    void setup() {
        member = Member.builder()
                .nickname("test")
                .age(18)
                .country("kr")
                .sex("m")
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build()
                ;
    }

    @DisplayName("생성")
    @Test
    void create() {
        // given
        // when
        Address address = Address.of("서울", "송파", member);

        // then
        assertThat(address).isNotNull();
        assertThat(address.getMember().getAge()).isEqualTo(18);
    }

    @DisplayName("수정")
    @Test
    void update() {
        // given
        Address address = Address.of("서울", "송파", member);

        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setCity("성남");
        addressRequest.setDistrict("수정");

        // when
        address.update(addressRequest.getCity(), addressRequest.getDistrict());

        // then
        assertThat(address).isNotNull();
        assertThat(address.getCity()).isEqualTo("성남");
        assertThat(address.getDistrict()).isEqualTo("수정");
    }
}