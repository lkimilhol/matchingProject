package com.lkimilhol.matchingProject.member.ui;

import com.lkimilhol.matchingProject.member.domain.Member;
import com.lkimilhol.matchingProject.member.dto.MemberRequest;
import com.lkimilhol.matchingProject.request.CreateMember;
import com.lkimilhol.matchingProject.response.ResultBody;
import com.lkimilhol.matchingProject.member.application.MemberService;
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
    @RequestMapping(value = "/member/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultBody> addMember(
            @Valid CreateMember createMember
    ) {
        Member member = memberService.addMember(createMember);
        return ResponseEntity.ok(new ResultBody(getMemberDto(member)));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/member/{nickname}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultBody> getMember(
            @PathVariable String nickname
    ) {
        Member member = memberService.getMember(nickname);
        return ResponseEntity.ok(new ResultBody(getMemberDto(member)));
    }

    private MemberRequest getMemberDto(Member member) {
        return MemberRequest.builder().member(member).build();
    }
}
