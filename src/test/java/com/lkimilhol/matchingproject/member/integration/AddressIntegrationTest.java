package com.lkimilhol.matchingproject.member.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

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
import com.lkimilhol.matchingproject.member.application.MemberService;
import com.lkimilhol.matchingproject.member.domain.Age;
import com.lkimilhol.matchingproject.member.domain.Country;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.domain.Nickname;
import com.lkimilhol.matchingproject.member.dto.AddressRequest;
import com.lkimilhol.matchingproject.member.dto.MemberResponse;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class AddressIntegrationTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private MemberService memberService;

    @DisplayName("주소 수정 통합 테스트")
    @Test
    void update() {
        // given
        Member member = Member.of(new Nickname("test"), "m", new Age(18), Country.KR);
        memberRepository.save(member);

        Address address = Address.of(City.get("서울"), new District("송파"), member);
        addressRepository.save(address);
        String city = "성남";
        String district = "수정";

        // when
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setCity(city);
        addressRequest.setDistrict(district);
        address.update(City.get(addressRequest.getCity()), new District(addressRequest.getDistrict()));

        Optional<Address> findAddress = addressRepository.findById(address.getId());

        // then
        assertThat(findAddress).isPresent();
        assertThat(findAddress.get().getId()).isEqualTo(address.getId());
        assertThat(findAddress.get().getCity().toName()).isEqualTo(city);
        assertThat(findAddress.get().getDistrict().getName()).isEqualTo(district);
    }

    @DisplayName("멤버 주소까지 조회")
    @Test
    void getMember() {
        // given
        Member member = Member.of(new Nickname("test"), "m", new Age(18), Country.KR);
        Address 송파 = Address.of(City.get("서울"), new District("송파"), member);
        Address 강남 = Address.of(City.get("서울"), new District("강남"), member);
        Address 서초 = Address.of(City.get("서울"), new District("서초"), member);

        memberRepository.save(member);
        addressRepository.save(송파);
        addressRepository.save(강남);
        addressRepository.save(서초);
        // when
        MemberResponse memberResponse = memberService.getMember(member.getNickname());
        // then
        assertThat(memberResponse.getAddresses().size()).isEqualTo(3);
    }
}
