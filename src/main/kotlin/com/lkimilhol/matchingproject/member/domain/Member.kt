package com.lkimilhol.matchingproject.member.domain

import com.lkimilhol.matchingproject.order.domain.Order
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Member (
    @Embedded val nickname: Nickname,
    val gender: Gender,
    @Embedded val age: Age,
    @Enumerated(EnumType.STRING) val country: Country
) {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "")
    val order: List<Order>? = null

    @Column(name = "update_time", columnDefinition = "DATETIME")
    var updateTime: LocalDateTime? = null

    @Column(name = "insert_time", columnDefinition = "DATETIME")
    var insertTime: LocalDateTime? = null
}
