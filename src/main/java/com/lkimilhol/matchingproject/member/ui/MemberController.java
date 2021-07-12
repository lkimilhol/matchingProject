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
