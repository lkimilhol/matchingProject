package com.lkimilhol.matchingProject.service.impl;

import com.lkimilhol.matchingProject.domain.Address;
import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.repository.AddressRepository;
import com.lkimilhol.matchingProject.request.CreateMember;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.MemberRepository;
import com.lkimilhol.matchingProject.service.MemberService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;

    public MemberServiceImpl(MemberRepository memberRepository, AddressRepository addressRepository) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
    }

    /*
     회원 가입
     */
    @Override
    public Member addMember(CreateMember createMember) {
        checkDuplicateMember(createMember);
        Member member = Member.builder()
                .nickname(createMember.getNickname())
                .age(createMember.getAge())
                .sex(createMember.getSex())
                .country(createMember.getCountry())
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        memberRepository.save(member);

        Address address = Address.builder()
                .member(member)
                .city(createMember.getCity())
                .district(createMember.getDistrict())
                .build()
                ;
        addressRepository.save(address);

        return member;
    }

    /*
     전체 회원 조회
     */
    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /*
    회원 정보 by id
     */
    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Optional<Member> findByNickname(String nickname) {
        return memberRepository.findByNickname(nickname);
    }

    private void checkDuplicateMember(CreateMember createMember) {
        Optional<Member> memberInfo = findByNickname(createMember.getNickname());

        if (memberInfo.isPresent()) {
            throw new CustomException(ErrorInfo.DUPLICATED_NICKNAME);
        }
    }
}
