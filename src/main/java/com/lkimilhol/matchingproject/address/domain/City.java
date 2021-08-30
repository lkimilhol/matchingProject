package com.lkimilhol.matchingproject.address.domain;

import com.lkimilhol.matchingproject.exception.NotFoundCityException;

public enum City {
    SEOUL("서울"),
    SUNGNAM("성남"),
    ;

    private String name;

    City(String name) {
        this.name = name;
    }

    static public City get(String name) {
        switch (name) {
            case "서울":
                return SEOUL;
            case "성남":
                return SUNGNAM;
        }

        throw new NotFoundCityException();
    }

    public String toName() {
        return this.name;
    }
}
