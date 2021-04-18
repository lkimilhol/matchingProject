package com.lkimilhol.matchingProject.repository.JPA;

import com.lkimilhol.matchingProject.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CreateMemberRepositoryJpaTest {

    @Autowired
    private EntityManager em;

    @Test
    public void save() {
        //given
        Member member = Member.builder()
                .nickname("test")
                .age(18)
                .country("kr")
                .sex("m")
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build()
                ;

        //when
        em.persist(member);

        //then
    }
}
