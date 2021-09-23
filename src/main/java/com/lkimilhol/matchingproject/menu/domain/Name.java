package com.lkimilhol.matchingproject.menu.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Name {
    private String contents;

    public Name(String contents) {
        this.contents = contents;
    }
}
