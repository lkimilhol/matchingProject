package com.lkimilhol.matchingproject.address.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class District {

    @Column
    private final String name;

    protected District() {
        throw new IllegalArgumentException();
    }

    public District(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(name, district.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
