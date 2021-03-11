package com.lkimilhol.matchingProject.repository.JPA;

import com.lkimilhol.matchingProject.domain.MemberInfo;
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
public class MemberInfoRepositoryJPATest {

    @Autowired
    private EntityManager em;

    @Test
    public void save() {
        //given
        MemberInfo memberInfo = MemberInfo.builder()
                .nickname("test")
                .age(18)
                .country("kr")
                .sex("m")
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build()
                ;

        //when
        em.persist(memberInfo);

        //then
    }
}
