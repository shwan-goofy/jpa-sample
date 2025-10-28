package org.example.jpastudy.repository;

import org.example.jpastudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}

// 헉 jpa 를 썻더니 sql 쿼리문이 싹 사라지겠다;;
// 연관관계라는 조금은 복잡한 개념만 이해하면 -> jpa 가 알아서 sql 쿼리문을 짜준다; 공짜점심을 먹을 수 있다!!
