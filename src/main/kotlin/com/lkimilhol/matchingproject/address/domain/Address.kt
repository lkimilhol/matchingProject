package com.lkimilhol.matchingproject.address.domain

import com.lkimilhol.matchingproject.member.domain.Member
import javax.persistence.*

@Entity
class Address(
    //시 ex) 서울시, 부산광역시, 광주광역시
    @Enumerated(EnumType.STRING)
    var city: City,

    //구 ex) 송파구, 강동
    @Embedded
    var district: District,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "member_id")
    val member: Member? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    val id: Long? = null

    fun update(city: City, district: District) {
        this.city = city
        this.district = district
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (id != other.id) return false
        if (city != other.city) return false
        if (district != other.district) return false
        if (member != other.member) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (city?.hashCode() ?: 0)
        result = 31 * result + (district?.hashCode() ?: 0)
        result = 31 * result + (member?.hashCode() ?: 0)
        return result
    }
}