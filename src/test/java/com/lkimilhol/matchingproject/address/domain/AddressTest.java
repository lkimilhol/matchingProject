package com.lkimilhol.matchingproject.address.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.matchingproject.member.domain.Age;
import com.lkimilhol.matchingproject.member.domain.Country;
import com.lkimilhol.matchingproject.member.domain.Gender;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.domain.Nickname;
import com.lkimilhol.matchingproject.member.dto.AddressRequest;

class AddressTest {

    public static final String CITY = "서울";
    public static final String DISTRICT = "송파";
    private Member member;

    @BeforeEach
    void setup() {
        member = new Member(new Nickname("test"), Gender.M, new Age(18), Country.KR);
    }

    @DisplayName("생성")
    @Test
    void create() {
        // given
        // when
        Address address = Address.of(City.get(CITY), new District(DISTRICT), member);

        // then
        assertThat(address).isNotNull();
        assertThat(address.getMember().getAge()).isEqualTo(new Age(18));
    }

    @DisplayName("수정")
    @Test
    void update() {
        // given
        Address address = Address.of(City.get(CITY), new District(DISTRICT), member);

        AddressRequest addressRequest = new AddressRequest(
                1L,
                1L,
                "성남",
                "수정"
        );

        // when
        address.update(City.get(addressRequest.getCity()), new District(addressRequest.getDistrict()));

        // then
        assertThat(address).isNotNull();
        assertThat(address.getCity().toName()).isEqualTo("성남");
        assertThat(address.getDistrict().getName()).isEqualTo("수정");
    }
}