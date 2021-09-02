package com.lkimilhol.matchingproject.member.domain;

import com.lkimilhol.matchingproject.exception.NotFoundCountryException;

public enum Country {
    KR, JA
    ;

    static public Country get(String name) {
        switch (name) {
            case "KR":
                return KR;
            case "JA":
                return JA;
        }

        throw new NotFoundCountryException();
    }
}
