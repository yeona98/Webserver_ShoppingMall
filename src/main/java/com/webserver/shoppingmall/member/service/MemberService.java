package com.webserver.shoppingmall.member.service;

import com.webserver.shoppingmall.member.dto.MemberRegisterDto;
import com.webserver.shoppingmall.member.model.Member;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface MemberService extends UserDetailsService {
    Long registerMember(final MemberRegisterDto payload);
    List<Member> getAllMembers();
    boolean existEmail(String email);
    Member getMemberByEmail(String email);
    void updateMember(Member member);
    Long deleteMember(String email);
}
