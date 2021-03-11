package com.lkimilhol.matchingProject.controller;

import com.google.gson.Gson;
import com.lkimilhol.matchingProject.domain.MemberInfo;
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
    private final Gson gson = new Gson();


    @PostMapping("/")
    public String getMember() {
        return "";
    }


    @RequestMapping(value = "/member/new",
            method = RequestMethod.POST
    )
    @ResponseBody
    public ResultBody addMember(
            @Validated MemberInfo memberInfo) {
        Long seq = memberSerivce.addMember(memberInfo);
        return new ResultBody(); //response 만든 뒤 수정
    }
}
