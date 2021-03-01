package com.lkimilhol.matchingProject.controller;

import com.google.gson.Gson;
import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.dto.MemberInfoDto;
import com.lkimilhol.matchingProject.service.impl.MemberSerivce;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    @ResponseBody
    public MemberInfo addMember(
            @Validated @RequestBody MemberInfoDto memberInfoDto) {
        Long seq = memberSerivce.addMember(memberInfoDto.dto());
        return null; //response 만든 뒤 수정
    }
}
