package com.lkimilhol.matchingproject.member.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NicknameTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        Nickname nickname = new Nickname("김메이어");
        // when
        // then
        assertThat(nickname).isNotNull();
    }
}
