package com.lkimilhol.matchingproject.address.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.matchingproject.exception.NotFoundCityException;

class CityTest {

    @DisplayName("데이터 불러오기")
    @Test
    void get() {
        // given
        String name = "서울";
        // when
        // then
        assertThat(City.get(name)).isEqualTo(City.SEOUL);
    }

    @DisplayName("잘못된 데이터")
    @Test
    void getFailed() {
        // given
        // when
        // then
        assertThatThrownBy(() -> {
            City.get("");
        }).isInstanceOf(NotFoundCityException.class);
    }
}