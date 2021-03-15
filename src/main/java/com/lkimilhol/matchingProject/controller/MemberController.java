package com.lkimilhol.matchingProject.controller;

import com.lkimilhol.matchingProject.dto.Member;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.response.ResultBody;
import com.lkimilhol.matchingProject.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @ResponseBody public ResultBody addMember(
            @Valid Member member, BindingResult bindingResult
    ) {
        try {
            if (bindingResult.hasErrors()) {
                throw new CustomException(ErrorInfo.INVALID_PARAMETER, bindingResult.getAllErrors());
            }
            return new ResultBody(memberService.addMember(member));
        } catch (CustomException e) {
            return new ResultBody(e.getErrorInfo());
        } catch (Exception e) {
            return new ResultBody(e.getMessage());
        }
    }
}
