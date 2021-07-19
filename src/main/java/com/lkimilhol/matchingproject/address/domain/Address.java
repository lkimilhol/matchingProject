package com.lkimilhol.matchingproject.address.domain;

import lombok.*;

import javax.persistence.*;

import com.lkimilhol.matchingproject.member.domain.Member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String city;        //시 ex) 서울시, 부산광역시, 광주광역시

    private String district;    //구 ex) 송파구, 강동

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    public Address(String city, String district, Member member) {
        this.city = city;
        this.district = district;
        this.member = member;
    }

    public static Address of(String city, String district, Member member) {
        return new Address(city, district, member);
    }

    public void update(String city, String district) {
        this.city = city;
        this.district = district;
    }
}
