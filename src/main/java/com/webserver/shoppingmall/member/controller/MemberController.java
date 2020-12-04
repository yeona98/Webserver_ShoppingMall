package com.webserver.shoppingmall.member.controller;

import com.webserver.shoppingmall.member.dto.MemberRegisterDto;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    // Admin?
    @GetMapping(value = "members")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.getAllMembers());
    }

    @PostMapping(value = "register")
    public ResponseEntity<Long> registerMember(@RequestBody @ModelAttribute final MemberRegisterDto payload
            , HttpServletResponse res) throws IOException {
        payload.setPassword(passwordEncoder.encode(payload.getPassword()));
        res.sendRedirect("/login");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.registerMember(payload));
    }

    @GetMapping("/emailCheck")
    public boolean emailCheck(String email) {
        System.out.println(email);
        boolean val = memberService.existEmail(email);
        System.out.println(val);
        return !val;
    }
}
