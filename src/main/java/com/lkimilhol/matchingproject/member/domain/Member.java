package com.lkimilhol.matchingproject.member.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.order.domain.Order;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Nickname nickname;

    private String sex;

    @Embedded
    private Age age;

    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToMany(mappedBy = "member")
    private List<Order> order;

    @Column(name = "update_time", columnDefinition = "DATETIME")
    private LocalDateTime updateTime;

    @Column(name = "insert_time", columnDefinition = "DATETIME")
    private LocalDateTime insertTime;

    public Member(long id) {
        this.id = id;
    }

    private Member (Nickname nickname, String sex, Age age, Country country) {
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.country = country;
        this.updateTime = LocalDateTime.now();
        this.insertTime = LocalDateTime.now();
    }

    public static Member of(Nickname nickname, String sex, Age age, Country country) {
        return new Member(nickname, sex, age, country);
    }
}



