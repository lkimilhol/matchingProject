package com.lkimilhol.matchingProject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String city;        //시 ex) 서울시, 부산광역시, 광주광역시

    private String district;    //구 ex) 송파구, 강동
}
