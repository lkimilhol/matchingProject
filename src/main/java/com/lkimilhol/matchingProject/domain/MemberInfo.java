package com.lkimilhol.matchingProject.domain;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER_INFO")
public class MemberInfo {
    public MemberInfo() {}

    @Builder
    public MemberInfo(
            Long id,
            String nickname,
            String sex,
            int age,
            String country,
            LocalDateTime updateTime,
            LocalDateTime insertTime
    ) {
        this.id = id;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.country = country;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nickname;

    private String sex;

    private int age;

    private String country;


    @Column(name = "update_time", columnDefinition = "DATETIME")
    private LocalDateTime updateTime;

    @Column(name = "insert_time", columnDefinition = "DATETIME")
    private LocalDateTime insertTime;

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }
//    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long seq) {
        this.id = seq;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

}
