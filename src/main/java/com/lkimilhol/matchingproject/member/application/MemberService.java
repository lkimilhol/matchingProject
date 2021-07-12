package com.lkimilhol.matchingproject.member.application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.address.repository.AddressRepository;
import com.lkimilhol.matchingproject.exception.NicknameAlreadyExistsException;
import com.lkimilhol.matchingproject.exception.NotFoundAddressException;
import com.lkimilhol.matchingproject.exception.NotFoundMemberException;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.exception.CustomException;
import com.lkimilhol.matchingproject.exception.ErrorInfo;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;
import com.lkimilhol.matchingproject.request.CreateMember;

import lombok.RequiredArgsConstructor;

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

        Address address = Address.builder()
                .city(createMember.getCity())
                .district(createMember.getDistrict())
                .build()
                ;

        Member member = Member.builder()
                .nickname(createMember.getNickname())
                .age(createMember.getAge())
                .sex(createMember.getSex())
                .country(createMember.getCountry())
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

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

    public Member getMember(String nickname) {
        return findByNickname(nickname).orElseThrow(NotFoundMemberException::new);
    }

    private void checkDuplicateMember(CreateMember createMember) {
        Optional<Member> memberInfo = findByNickname(createMember.getNickname());

        if (memberInfo.isPresent()) {
            throw new NicknameAlreadyExistsException();
        }
    }
}
