package com.lkimilhol.matchingProject.service.impl;

import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.dto.MemberDto;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.MemberInfoRepository;
import com.lkimilhol.matchingProject.service.MemberService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberInfoRepository memberInfoRepository;

    public MemberServiceImpl(MemberInfoRepository memberInfoRepository) {
        this.memberInfoRepository = memberInfoRepository;
    }

    /*
     회원 가입
     */
    @Override
    public Member addMember(MemberDto memberDto) {
        checkDuplicateMember(memberDto);
        Member member = Member.builder()
                .nickname(memberDto.getNickname())
                .age(memberDto.getAge())
                .sex(memberDto.getSex())
                .country(memberDto.getCountry())
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        memberInfoRepository.save(member);
        return member;
    }

    /*
     전체 회원 조회
     */
    @Override
    public List<Member> findMembers() {
        return memberInfoRepository.findAll();
    }

    /*
    회원 정보 by id
     */
    @Override
    public Optional<Member> findById(Long id) {
        return memberInfoRepository.findById(id);
    }

    @Override
    public Optional<Member> findByNickname(String nickname) {
        Optional<Member> memberInfoByNickname = memberInfoRepository.findByNickname(nickname);

        memberInfoByNickname.orElseThrow();

        return memberInfoRepository.findByNickname(nickname);
    }

    private void checkDuplicateMember(MemberDto memberDto) {
        Optional<Member> memberInfo = findByNickname(memberDto.getNickname());

        if (memberInfo.isPresent()) {
            throw new CustomException(ErrorInfo.DUPLICATED_NICKNAME);
        }
    }
}
