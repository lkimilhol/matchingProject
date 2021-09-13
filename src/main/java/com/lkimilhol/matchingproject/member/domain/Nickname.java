package com.lkimilhol.matchingproject.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Nickname {

    @Column(name = "nickname")
    private String contents;

    public Nickname(String contents) {
        this.contents = contents;
    }

    public String toString() {
        return this.contents;
    }
}
