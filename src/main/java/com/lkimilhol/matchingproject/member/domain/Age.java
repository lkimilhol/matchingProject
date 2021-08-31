package com.lkimilhol.matchingproject.member.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Age {

    @Column(name = "age")
    private final int amount;

    public Age() {
        throw new IllegalArgumentException();
    }

    public Age(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Age age = (Age) o;
        return amount == age.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
