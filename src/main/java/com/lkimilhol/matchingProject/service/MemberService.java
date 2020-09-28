package com.lkimilhol.matchingProject.service;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원 가입
     */
    public Long addMember(MemberInfo memberInfo) {
//        validateDuplicateMember(memberInfo); // 중복회원검증
        memberInfo.setInsertTime(LocalDateTime.now());
        memberInfo.setUpdateTime(LocalDateTime.now());
        memberRepository.save(memberInfo);
        return memberInfo.getId();
    }

    private void validateDuplicateMember(MemberInfo memberInfo) {
        memberRepository.findByNickname(memberInfo.getNickname())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
     * 전체 회원 조회
     */
    public List<MemberInfo> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<MemberInfo> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
