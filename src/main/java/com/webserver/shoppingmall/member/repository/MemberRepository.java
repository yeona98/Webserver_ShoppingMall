package com.webserver.shoppingmall.member.repository;

import com.webserver.shoppingmall.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
