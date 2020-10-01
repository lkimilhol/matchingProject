package com.lkimilhol.matchingProject.service;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.repository.MemberInfoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberInfoRepository memberInfoRepository;

    public MemberService(MemberInfoRepository memberInfoRepository) {
        this.memberInfoRepository = memberInfoRepository;
    }

    /*
     * 회원 가입
     */
    public Long addMember(MemberInfo memberInfo) {
//        validateDuplicateMember(memberInfo); // 중복회원검증
        memberInfo.setInsertTime(LocalDateTime.now());
        memberInfo.setUpdateTime(LocalDateTime.now());
        memberInfoRepository.save(memberInfo);
        return memberInfo.getId();
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
