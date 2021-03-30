package com.lkimilhol.matchingProject.controller;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.dto.Member;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.response.ResultBody;
import com.lkimilhol.matchingProject.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
            @Valid Member member
    ) {
        MemberInfo memberInfo = memberService.addMember(member);
        return ResponseEntity.ok(new ResultBody(memberInfo));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/member/{nickname}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultBody> getMember(
            @PathVariable String nickname
    ) {
        Optional<MemberInfo> member = memberService.findByNickname(nickname);
        return ResponseEntity.ok(new ResultBody(member.get()));
    }

}
