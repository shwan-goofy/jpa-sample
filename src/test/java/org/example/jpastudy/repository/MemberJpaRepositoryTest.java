package org.example.jpastudy.repository;

import jakarta.transaction.Transactional;
import org.example.jpastudy.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {
    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @Test
    void testMember() {
        // given
        Member member = new Member();
        member.setUsername("memberA");
        member.setAge(10);

        // when
        Member savedMember = memberJpaRepository.save(member);

        // then
        Member foundMember = memberJpaRepository.findById(savedMember.getId()).get();
        System.out.println(foundMember);
    }

    @Test
    void basicCRUD() {
        // given
        Member member1 = new Member();
        member1.setUsername("member1");
        member1.setAge(20);
        Member member2 = new Member();
        member2.setUsername("member2");
        member2.setAge(30);

        // when
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        // then
        Member foundMember1 = memberJpaRepository.findById(member1.getId()).get();
        Member foundMember2 = memberJpaRepository.findById(member2.getId()).get();

        System.out.println("foundMember1 = " + foundMember1);
        System.out.println("foundMember2 = " + foundMember2);

        // count
        long count = memberJpaRepository.count();
        System.out.println("count = " + count); // 2개 저장

        // findAll
        var allMembers = memberJpaRepository.findAll();
        System.out.println("allMembers = " + allMembers); // 2개 조회가 됩니다

        // delete
        memberJpaRepository.delete(member1);
        memberJpaRepository.delete(member2);

        long deletedCount = memberJpaRepository.count();
        System.out.println("deletedCount = " + deletedCount);
    }

}