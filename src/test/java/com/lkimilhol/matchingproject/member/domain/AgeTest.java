package com.lkimilhol.matchingproject.member.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgeTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        Age age = new Age(10);
        // when
        // then
        assertThat(age).isEqualTo(new Age(10));
    }
}