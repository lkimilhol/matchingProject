package com.lkimilhol.matchingproject.address.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.matchingproject.member.domain.Age;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.dto.AddressRequest;

class AddressTest {

    private Member member;

    @BeforeEach
    void setup() {
        member = Member.of("test", "m", new Age(18), "kr");
    }

    @DisplayName("생성")
    @Test
    void create() {
        // given
        // when
        Address address = Address.of(City.get("서울"), new District("송파"), member);

        // then
        assertThat(address).isNotNull();
        assertThat(address.getMember().getAge()).isEqualTo(new Age(18));
    }

    @DisplayName("수정")
    @Test
    void update() {
        // given
        Address address = Address.of(City.get("서울"), new District("송파"), member);

        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setCity("성남");
        addressRequest.setDistrict("수정");

        // when
        address.update(City.get(addressRequest.getCity()), new District(addressRequest.getDistrict()));

        // then
        assertThat(address).isNotNull();
        assertThat(address.getCity().toName()).isEqualTo("성남");
        assertThat(address.getDistrict().getName()).isEqualTo("수정");
    }
}