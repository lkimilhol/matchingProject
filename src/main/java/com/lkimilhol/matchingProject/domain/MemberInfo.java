package com.lkimilhol.matchingProject.domain;

import javax.persistence.*;

@Entity
public class MemberInfo {

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nickname;
    private String sex;
    private int age;
    private String country;
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
