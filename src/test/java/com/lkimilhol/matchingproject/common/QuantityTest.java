package com.lkimilhol.matchingproject.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}