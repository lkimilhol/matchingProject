package com.lkimilhol.matchingProject.controller;

import com.google.gson.Gson;
import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.service.impl.MemberSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    private final MemberSerivce memberSerivce;

    public MemberController(MemberSerivce memberSerivce) {
        this.memberSerivce = memberSerivce;
    }
    private final Gson gson = new Gson();


    @PostMapping("/")
    public String getMember() {
        return "";
    }


    @RequestMapping(value = "/member/new" , method = RequestMethod.POST)
    @ResponseBody
    public MemberInfo addMember(@RequestBody MemberInfo memberInfo) {
        gson.toJson(memberInfo);
        memberSerivce.addMember(memberInfo);
        return memberInfo;
    }
}
