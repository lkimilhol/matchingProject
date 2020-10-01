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
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setNickname("yy");
        memberInfo.setAge(81);
        memberInfo.setCountry("kr");
        memberInfo.setSex("m");
        memberInfo.setInsertTime(LocalDateTime.now());
        memberInfo.setUpdateTime(LocalDateTime.now());

        //when
        em.persist(memberInfo);

        //then
    }
}
