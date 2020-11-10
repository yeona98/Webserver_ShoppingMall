package com.webserver.shoppingmall.member.service;

import com.webserver.shoppingmall.member.dto.MemberRegisterDto;
import com.webserver.shoppingmall.member.model.Member;

import java.util.List;

public interface MemberService {
    Long registerMember(final MemberRegisterDto payload);
    List<Member> getAllMembers();
}
