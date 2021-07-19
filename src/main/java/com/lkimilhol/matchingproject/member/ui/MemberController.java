package com.lkimilhol.matchingproject.member.ui;

import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.dto.MemberRequest;
import com.lkimilhol.matchingproject.request.CreateMember;
import com.lkimilhol.matchingproject.response.ResultBody;
import com.lkimilhol.matchingproject.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/")
    public String getMember() {
        return "";
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/member/new")
    @ResponseBody
    public ResponseEntity<ResultBody> addMember(
            @Valid CreateMember createMember
    ) {
        return ResponseEntity.ok(new ResultBody(getMemberDto(memberService.addMember(createMember))));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/member/{nickname}")
    @ResponseBody
    public ResponseEntity<ResultBody> getMember(
            @PathVariable String nickname
    ) {
        return ResponseEntity.ok(new ResultBody(getMemberDto(memberService.getMember(nickname))));
    }

    private MemberRequest getMemberDto(Member member) {
        return MemberRequest.builder().member(member).build();
    }
}
