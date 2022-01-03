package com.lkimilhol.matchingproject.member.domain

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.Positive

@Embeddable
data class Age(@Positive @Column val amount: Int)