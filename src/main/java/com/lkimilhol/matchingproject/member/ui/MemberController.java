package com.lkimilhol.matchingproject.member.ui;

import java.util.List;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.dto.AddressRequest;
import com.lkimilhol.matchingproject.member.dto.MemberRequest;
import com.lkimilhol.matchingproject.member.dto.MemberResponse;
import com.lkimilhol.matchingproject.request.CreateMember;
import com.lkimilhol.matchingproject.response.ResultBody;
import com.lkimilhol.matchingproject.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/")
    public String getMember() {
        return "";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/members")
    @ResponseBody
    public ResponseEntity<ResultBody> addMember(
            @Valid CreateMember createMember
    ) {
        return ResponseEntity.ok(new ResultBody(getMemberDto(memberService.addMember(createMember))));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/members/{nickname}")
    @ResponseBody
    public ResponseEntity<ResultBody> getMember(@PathVariable String nickname) {
        return ResponseEntity.ok(new ResultBody(memberService.getMember(nickname)));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/members/address")
    @ResponseBody
    public ResponseEntity<Void> updateAddress(@RequestBody AddressRequest addressRequest) {
        memberService.updateAddress(addressRequest);
        return ResponseEntity.noContent().build();
    }

    private MemberRequest getMemberDto(Member member) {
        return MemberRequest.builder().member(member).build();
    }
}
