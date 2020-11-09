package com.webserver.shoppingmall.classes.member.controller;

import com.webserver.shoppingmall.classes.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;
}
