package com.lkimilhol.matchingproject.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.matchingproject.exception.NegativeValueException;

class QuantityTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        // when
        Quantity quantity = new Quantity(7);
        // then
        assertThat(quantity).isNotNull();
    }

    @DisplayName("차감")
    @Test
    void sub() {
        // given
        Quantity quantity = new Quantity(10);
        Quantity subTarget = new Quantity(5);
        // when
        Quantity actual = quantity.sub(subTarget);
        // then
        assertThat(actual).isEqualTo(new Quantity(5));
    }

    @DisplayName("생성 실패")
    @Test
    void createFailedByNegative() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Quantity(-10))
                .isInstanceOf(NegativeValueException.class);
    }
}