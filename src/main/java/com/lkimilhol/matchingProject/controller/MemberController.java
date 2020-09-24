package com.lkimilhol.matchingProject.controller;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/")
    public String getMember() {
        return "";
    }

    @PostMapping("/member/new")
    @ResponseBody
    public MemberInfo addMember(@RequestBody MemberInfo memberInfo) {
        memberService.addMember(memberInfo);
        return memberInfo;
    }
}
