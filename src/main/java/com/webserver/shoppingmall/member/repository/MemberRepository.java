package com.webserver.shoppingmall.member.repository;

import com.webserver.shoppingmall.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByEmail(final String email);

    Optional<Member> findByEmail(final String email);

    Member findMemberByEmail(String email);

    Member findMemberById(Long id);

}
