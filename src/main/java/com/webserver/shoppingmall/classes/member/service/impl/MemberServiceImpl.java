package com.webserver.shoppingmall.classes.member.service.impl;

import com.webserver.shoppingmall.classes.member.repository.MemberRepository;
import com.webserver.shoppingmall.classes.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
}
