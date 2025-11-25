package org.example.jpastudy.repository;

import jakarta.persistence.LockModeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.QueryHint;
import org.example.jpastudy.domain.Member;
import org.example.jpastudy.dto.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Page<Member> findByUsernameContaining(String username, Pageable pageable);
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
}