package com.lkimilhol.matchingProject.controller;

import com.lkimilhol.matchingProject.domain.MemberInfo;
import com.lkimilhol.matchingProject.dto.Member;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.response.ResultBody;
import com.lkimilhol.matchingProject.service.MemberService;
import org.springframework.http.HttpStatus;
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
    @ExceptionHandler(CustomException.class)
    public ResultBody addMember(
            @Valid Member member, BindingResult bindingResult
    ) {
        MemberInfo memberInfo = memberService.addMember(member);
        return new ResultBody(memberInfo);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/member/{nickname}", method = RequestMethod.GET)
    @ResponseBody
    public ResultBody getMember(
            @PathVariable String nickname
    ) {
        try {
            //TODO 여기서 empty 체크를 하는게 맞을 것인가?
            //TODO 테스트케이스 작성을 해보도록 하자.
            Optional<MemberInfo> member = memberService.findByNickname(nickname);
            if (member.isEmpty()) {
                throw new CustomException(ErrorInfo.NOT_EXISTS_MEMBER);
            }
            return new ResultBody(member.get());
        } catch (Exception e) {
            return new ResultBody(e.getMessage());
        }
    }

}
