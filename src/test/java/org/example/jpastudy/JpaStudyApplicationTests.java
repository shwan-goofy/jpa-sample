package org.example.jpastudy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.apache.catalina.core.ApplicationContext;
import org.example.jpastudy.domain.Member;
import org.example.jpastudy.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class JpaStudyApplicationTests {
    @Autowired
    ApplicationContext ac;

    @Test
    void sampel() {
        ac.getBeanDefinitionNames();
    }
}
