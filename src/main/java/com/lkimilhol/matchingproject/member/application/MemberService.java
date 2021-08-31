package com.lkimilhol.matchingproject.member.application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.address.domain.City;
import com.lkimilhol.matchingproject.address.domain.District;
import com.lkimilhol.matchingproject.address.repository.AddressRepository;
import com.lkimilhol.matchingproject.exception.NicknameAlreadyExistsException;
import com.lkimilhol.matchingproject.exception.NotFoundAddressException;
import com.lkimilhol.matchingproject.exception.NotFoundMemberException;
import com.lkimilhol.matchingproject.member.domain.Age;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.dto.AddressRequest;
import com.lkimilhol.matchingproject.member.dto.MemberResponse;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;
import com.lkimilhol.matchingproject.request.CreateMember;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;

    /*
     회원 가입
     */
    @Transactional
    public Member addMember(CreateMember createMember) {
        checkDuplicateMember(createMember);

        var member = Member.of(createMember.getNickname(), createMember.getSex(), new Age(createMember.getAge()), createMember.getCountry());
        Address address = Address.of(City.get(createMember.getCity()), new District(createMember.getDistrict()), member);

        addressRepository.save(address);
        memberRepository.save(member);

        return member;
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(NotFoundMemberException::new);
    }

    public Optional<Member> findByNickname(String nickname) {
        return memberRepository.findByNickname(nickname);
    }

    public Address findAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(NotFoundAddressException::new);
    }

    public MemberResponse getMember(String nickname) {
        Member member = findByNickname(nickname).orElseThrow(NotFoundMemberException::new);
        List<Address> addresses = addressRepository.findAddressesByMember(member);
        return MemberResponse.of(member, addresses);
    }

    private void checkDuplicateMember(CreateMember createMember) {
        Optional<Member> memberInfo = findByNickname(createMember.getNickname());

        if (memberInfo.isPresent()) {
            throw new NicknameAlreadyExistsException();
        }
    }

    public void updateAddress(AddressRequest addressRequest) {
        memberRepository.findById(addressRequest.getMemberId())
                .orElseThrow(NotFoundMemberException::new);

        Address address = addressRepository.findById(addressRequest.getAddressId())
                .orElseThrow(NotFoundAddressException::new);

        address.update(City.get(addressRequest.getCity()), new District(addressRequest.getDistrict()));
    }
}
