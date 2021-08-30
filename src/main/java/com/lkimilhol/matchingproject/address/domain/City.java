package com.lkimilhol.matchingproject.address.domain;

import com.lkimilhol.matchingproject.exception.NotFoundCityException;

public enum City {
    SEOUL("서울시"),
    ;

    private String name;

    City(String name) {
        this.name = name;
    }

    static public City get(String name) {
        switch (name) {
            case "서울시":
                return SEOUL;
        }

        throw new NotFoundCityException();
    }
}
