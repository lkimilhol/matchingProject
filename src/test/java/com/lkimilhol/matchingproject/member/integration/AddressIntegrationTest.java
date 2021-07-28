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
import com.lkimilhol.matchingproject.address.repository.AddressRepository;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.dto.AddressRequest;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class AddressIntegrationTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    @DisplayName("주소 수정 통합 테스트")
    @Test
    void update() {
        // given
        Member member = Member.of("test", "m", 18, "kr");
        memberRepository.save(member);

        Address address = Address.of("서울", "송파", member);
        addressRepository.save(address);
        String city = "성남";
        String district = "수정";

        // when
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setCity(city);
        addressRequest.setDistrict(district);
        address.update(addressRequest.getCity(), addressRequest.getDistrict());

        Optional<Address> findAddress = addressRepository.findById(address.getId());

        // then
        assertThat(findAddress).isPresent();
        assertThat(findAddress.get().getId()).isEqualTo(address.getId());
        assertThat(findAddress.get().getCity()).isEqualTo(city);
        assertThat(findAddress.get().getDistrict()).isEqualTo(district);
    }
}
