package com.lkimilhol.matchingProject.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    private final Gson gson = new Gson();


    @PostMapping("/")
    public String getMember() {
        return "";
    }


    @RequestMapping(value = "/member/new" , method = RequestMethod.POST, produces = "application/json; charset=utf8")
    @ResponseBody
    public MemberInfo addMember(@RequestBody MemberInfo memberInfo) {
        gson.toJson(memberInfo);
        memberService.addMember(memberInfo);
        return memberInfo;
    }
}
