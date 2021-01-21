package com.webserver.shoppingmall.member.controller;

import com.webserver.shoppingmall.member.dto.MemberRegisterRequestDto;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(MemberController.class);

    // Admin?
    @GetMapping(value = "members")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.getAllMembers());
    }


    @PostMapping(value = "register") // consumes = "application/json"
    public ResponseEntity<?> registerMember(@RequestBody @ModelAttribute final MemberRegisterRequestDto payload,
                                            HttpServletResponse res) throws IOException {

        payload.setPassword(passwordEncoder.encode(payload.getPassword()));

        log.info("email :  {} ", payload.getEmail());
        res.sendRedirect("/login"); // X
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
