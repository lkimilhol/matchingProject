package com.lkimilhol.matchingProject.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER_INFO")
@Builder
@Getter
public class MemberInfo {

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
}
