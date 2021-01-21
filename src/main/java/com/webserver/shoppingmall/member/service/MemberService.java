package com.webserver.shoppingmall.member.service;

import com.webserver.shoppingmall.member.dto.MemberRegisterRequestDto;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.dto.MemberUpdateRequestDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberService extends UserDetailsService {

    Long register(MemberRegisterRequestDto payload);

    Long registerMember(final MemberRegisterRequestDto payload);

    void updateMember(MemberUpdateRequestDto form);

    Long deleteMember(String email);

    void deleteMemberById(Long id);

    Member findMemberById(Long id);

    List<Member> getAllMembers();

    boolean existEmail(String email);

    Member getMemberByEmail(String email);

}
