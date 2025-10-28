package org.example.jpastudy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.example.jpastudy.domain.Member;
import org.example.jpastudy.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaStudyApplicationTests {
    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Transactional
    void testEntity() {
        // save team_a
        Team teamA = new Team();
        teamA.setName("TeamA");
        entityManager.persist(teamA); // save

        // save member1
        Member member1 = new Member();
        member1.setUsername("member1");
        member1.setAge(10);
        member1.changeTeam(teamA);
        entityManager.persist(member1);

        // save member2
        Member member2 = new Member();
        member2.setUsername("member2");
        member2.setAge(20);
        member2.changeTeam(teamA);
        entityManager.persist(member2);

        entityManager.flush();
        entityManager.clear(); // save

//        Team foundTeam = entityManager.find(Team.class, teamA.getId());
//        System.out.println("Found Team: " + foundTeam);
//        for (Member member : foundTeam.getMembers()) {
//            System.out.println(" - Member: " + member);
//        }
    }
}
