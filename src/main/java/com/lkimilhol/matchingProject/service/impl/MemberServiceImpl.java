package com.lkimilhol.matchingProject.service.impl;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.dto.Member;
import com.lkimilhol.matchingProject.repository.MemberInfoRepository;
import com.lkimilhol.matchingProject.service.MemberService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {
    private final MemberInfoRepository memberInfoRepository;

    public MemberServiceImpl(MemberInfoRepository memberInfoRepository) {
        this.memberInfoRepository = memberInfoRepository;
    }

    /*
     * 회원 가입
     */
    public MemberInfo addMember(Member member) {
        MemberInfo memberInfo = MemberInfo.builder()
                .nickname(member.getNickname())
                .age(member.getAge())
                .sex(member.getSex())
                .country(member.getCountry())
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        memberInfoRepository.save(memberInfo);
        return memberInfo;
    }

    private void validateDuplicateMember(MemberInfo memberInfo) {
        memberInfoRepository.findByNickname(memberInfo.getNickname())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
     * 전체 회원 조회
     */
    public List<MemberInfo> findMembers() {
        return memberInfoRepository.findAll();
    }

    public Optional<MemberInfo> findOne(Long memberId) {
        return memberInfoRepository.findById(memberId);
    }
}
