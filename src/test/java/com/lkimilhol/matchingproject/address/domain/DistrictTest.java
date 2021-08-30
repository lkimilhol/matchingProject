package com.lkimilhol.matchingproject.address.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistrictTest {

    @DisplayName("생성")
    @Test
    void createName() {
        // given
        District district = new District("송파구");
        // when
        String name = district.getName();
        // then
        assertThat(name).isEqualTo("송파구");
    }

    @DisplayName("생성-이름없음")
    @Test
    void createFailedByName() {
        // given
        District district = new District();
        // when
        String name = district.getName();
        // then
        assertThat(name).isEqualTo(District.DEFAULT);
    }
}