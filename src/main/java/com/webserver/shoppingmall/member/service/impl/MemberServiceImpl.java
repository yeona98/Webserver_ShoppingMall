package com.webserver.shoppingmall.member.service.impl;

import com.webserver.shoppingmall.member.dto.MemberRegisterRequestDto;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;


    @Override
    public Long register(MemberRegisterRequestDto payload) {
        return null;
    }
}