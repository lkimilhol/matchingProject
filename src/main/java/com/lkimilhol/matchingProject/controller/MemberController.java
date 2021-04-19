package com.lkimilhol.matchingProject.controller;

import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.dto.MemberDto;
import com.lkimilhol.matchingProject.request.CreateMember;
import com.lkimilhol.matchingProject.response.ResultBody;
import com.lkimilhol.matchingProject.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

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
        return ResponseEntity.ok(new ResultBody(member));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/member/{nickname}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultBody> getMember(
            @PathVariable String nickname
    ) {
        MemberDto member = memberService.getMember(nickname);
        return ResponseEntity.ok(new ResultBody(member));
    }

}
