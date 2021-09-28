package com.lkimilhol.matchingproject.menu.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class MenuName {
    private String contents;

    public MenuName(String contents) {
        this.contents = contents;
    }
}
