package com.webserver.shoppingmall.member.controller;

import com.webserver.shoppingmall.member.dto.MemberRegisterDto;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    // Admin?
    @GetMapping(value = "members")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.getAllMembers());
    }

    @PostMapping(value = "member/register")
    public ResponseEntity<Long> registerMember(@RequestBody @ModelAttribute final MemberRegisterDto payload) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.registerMember(payload));
    }

}
