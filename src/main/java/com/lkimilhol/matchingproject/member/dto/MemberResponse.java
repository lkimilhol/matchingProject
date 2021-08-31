package com.lkimilhol.matchingproject.member.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.member.domain.Member;

@Getter
@NoArgsConstructor
public class MemberResponse {
    private Long id;
    private String nickname;
    private String sex;
    private int age;
    private LocalDateTime insertTime;
    private List<AddressResponse> addresses;

    public MemberResponse(Long id, String nickname, String sex, int age, LocalDateTime insertTime, List<AddressResponse> addresses) {
        this.id = id;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.insertTime = insertTime;
        this.addresses = addresses;
    }

    public static MemberResponse of(Member member, List<Address> addresses) {
        return new MemberResponse(member.getId(), member.getNickname(), member.getSex(), member.getAge().amount(), member.getInsertTime(), AddressResponse.listOf(addresses));
    }
}
