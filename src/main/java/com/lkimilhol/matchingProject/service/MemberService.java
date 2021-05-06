package com.lkimilhol.matchingProject.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingProject.domain.Address;
import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.AddressRepository;
import com.lkimilhol.matchingProject.repository.MemberRepository;
import com.lkimilhol.matchingProject.request.CreateMember;
import com.lkimilhol.matchingProject.service.MemberService;

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
        return memberRepository.findById(id);
    }

    public Optional<Member> findByNickname(String nickname) {
        return memberRepository.findByNickname(nickname);
    }

    public Address findAddress(Long id) {
        return addressRepository.findById(id);
    }

    public Member getMember(String nickname) {
        Optional<Member> member = findByNickname(nickname);

        if (member.isEmpty()) {
            throw new CustomException(ErrorInfo.NOT_EXISTS_MEMBER);
        }

        return member.get();
    }

    private void checkDuplicateMember(CreateMember createMember) {
        Optional<Member> memberInfo = findByNickname(createMember.getNickname());

        if (memberInfo.isPresent()) {
            throw new CustomException(ErrorInfo.DUPLICATED_NICKNAME);
        }
    }
}
