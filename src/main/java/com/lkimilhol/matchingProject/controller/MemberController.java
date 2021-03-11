package com.lkimilhol.matchingProject.controller;

import com.google.gson.Gson;
import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.dto.Member;
import com.lkimilhol.matchingProject.response.ResultBody;
import com.lkimilhol.matchingProject.service.impl.MemberSerivce;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    private final MemberSerivce memberSerivce;

    public MemberController(MemberSerivce memberSerivce) {
        this.memberSerivce = memberSerivce;
    }

    @PostMapping("/")
    public String getMember() {
        return "";
    }


    @RequestMapping(value = "/member/new", method = RequestMethod.POST)
    @ResponseBody public ResultBody addMember(
            @Validated Member member
    ) {
        return new ResultBody(memberSerivce.addMember(member));
    }
}
