package org.example.jpastudy.repository;

import jakarta.transaction.Transactional;
import org.example.jpastudy.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    void testMember() {
        // given
        Member member = new Member();
        member.setUsername("memberA");
        member.setAge(99);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member foundMember = memberRepository.findById(savedMember.getId()).get();
        System.out.println(foundMember);
    }

    @Test
    void testCRUD() {
        // Create
        Member member1 = new Member();
        member1.setUsername("member1");
        member1.setAge(25);
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setUsername("member2");
        member2.setAge(30);
        memberRepository.save(member2);

        // 리스트 조회 검증
        var allMembers = memberRepository.findAll();
        assert allMembers.size() == 2;

        // 카운트 검증
        long count = memberRepository.count();
        assert count == 2;

        // 삭제 검증
        memberRepository.delete(member1);
        count = memberRepository.count();
        assert count == 1;

        // 단건 조회 검증
        Member foundMember = memberRepository.findById(member2.getId()).get();
        assert foundMember.getUsername().equals("member2");
    }
}
