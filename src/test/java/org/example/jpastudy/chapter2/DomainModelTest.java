package org.example.jpastudy.chapter2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.jpastudy.domain.Member;
import org.example.jpastudy.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DomainModelTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void testMemberAndTeam() {
        // 팀 생성
        Team team = new Team();
        team.setName("TeamA");
        em.persist(team);

        // 회원 생성
        Member member = new Member();
        member.setUsername("member1");
        member.setAge(20);
        member.setTeam(team);
        em.persist(member);

        // 영속성 컨텍스트 초기화
        em.flush();
        em.clear();

        // 회원 조회
        Member findMember = em.find(Member.class, member.getId());

        // 검증
        assertThat(findMember.getTeam().getName()).isEqualTo(team.getName());
    }
}
