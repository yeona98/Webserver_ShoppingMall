package com.webserver.shoppingmall.system.controller;

import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/login")
    public String getLoginForm() {
        return "loginForm";
    }

    @GetMapping("/posts")
    public String getPosts() {
        return "posts";
    }

    @GetMapping("/test")
    public String test() {
        return "authpage";
    }
}
