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
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Member

        if (nickname != other.nickname) return false
        if (gender != other.gender) return false
        if (age != other.age) return false
        if (country != other.country) return false
        if (id != other.id) return false
        if (order != other.order) return false
        if (updateTime != other.updateTime) return false
        if (insertTime != other.insertTime) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nickname.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + age.hashCode()
        result = 31 * result + country.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (order?.hashCode() ?: 0)
        result = 31 * result + (updateTime?.hashCode() ?: 0)
        result = 31 * result + (insertTime?.hashCode() ?: 0)
        return result
    }


}
