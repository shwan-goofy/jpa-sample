package org.example.jpastudy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.jpastudy.domain.Member;
import org.example.jpastudy.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.core.EntityMetadata;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TeamRepositoryTest {
    @Autowired TeamRepository teamRepository;
    @Autowired MemberRepository memberRepository;
    
    @PersistenceContext
    EntityManager em;

    @Test
    void findMemberlazy() {
        // given
        Team teamA = new Team();
        teamA.setName("teamA");
        Team teamB = new Team();
        teamB.setName("teamB");

        // when
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        // given
        Member memberA = new Member("member1", 10, teamA);
        Member memberB = new Member("member2", 20, teamB);
        
        // when
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        //================================================================================================================
        
        // sql execute
        em.flush();
        em.clear();
        
        // then
        teamRepository.findAll();
    }

//    @Test
//    void sampleForTransaction() {
//        EntityTransaction tx = em.getTransaction();
//
//        try {
//            Member jisurgPark = new Member("member1", 10);
//            jisurgPark.enrollTeam(manU);
//            em.persist(memberA);
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        }
//    }
}