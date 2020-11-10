package com.webserver.shoppingmall.member.repository;

import com.webserver.shoppingmall.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(final String email);
    Optional<Member> findByEmail(final String email);
}
