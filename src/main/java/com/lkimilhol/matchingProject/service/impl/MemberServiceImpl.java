package com.lkimilhol.matchingProject.service.impl;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.dto.Member;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.MemberInfoRepository;
import com.lkimilhol.matchingProject.service.MemberService;
import com.mysql.cj.exceptions.ConnectionIsClosedException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {
    private final MemberInfoRepository memberInfoRepository;

    public MemberServiceImpl(MemberInfoRepository memberInfoRepository) {
        this.memberInfoRepository = memberInfoRepository;
    }

    /*
     회원 가입
     */
    @Override
    public MemberInfo addMember(Member member) throws CustomException {
        checkDuplicateMember(member);
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

    /*
     전체 회원 조회
     */
    @Override
    public List<MemberInfo> findMembers() {
        return memberInfoRepository.findAll();
    }

    /*
    회원 정보 by id
     */
    @Override
    public Optional<MemberInfo> findById(Long id) {
        return memberInfoRepository.findById(id);
    }

    @Override
    public Optional<MemberInfo> findByNickname(String nickname) {
        Optional<MemberInfo> memberInfoByNickname = memberInfoRepository.findByNickname(nickname);

        memberInfoByNickname.orElseThrow();

        return memberInfoRepository.findByNickname(nickname);
    }

    private void checkDuplicateMember(Member member) throws CustomException {
        Optional<MemberInfo> memberInfo = findByNickname(member.getNickname());

        if (memberInfo.isPresent()) {
            throw new CustomException(ErrorInfo.DUPLICATED_NICKNAME);
        }
    }
}
