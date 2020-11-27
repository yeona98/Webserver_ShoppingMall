package com.webserver.shoppingmall.system.controller;

import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UiController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name","min");
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterForm() {
        return "registerForm";
    }
}
