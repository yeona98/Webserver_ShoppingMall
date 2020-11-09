package com.webserver.shoppingmall.classes.member.repository;

import com.webserver.shoppingmall.classes.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
