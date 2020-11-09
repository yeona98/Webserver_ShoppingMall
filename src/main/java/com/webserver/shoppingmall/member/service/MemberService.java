package com.webserver.shoppingmall.member.service;

import com.webserver.shoppingmall.member.dto.MemberRegisterRequestDto;

public interface MemberService {
    Long register(MemberRegisterRequestDto payload);
}
