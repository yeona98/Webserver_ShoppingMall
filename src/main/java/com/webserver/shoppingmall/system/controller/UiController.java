package com.webserver.shoppingmall.system.controller;

import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.model.MemberForm;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class UiController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

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

    @GetMapping("/account")
    public String upDateMemberForm(Model model, Principal principal) {
        Member member = memberService.getMemberByEmail(principal.getName());
        MemberForm form = new MemberForm();
        form.setId(member.getId());
        form.setEmail(member.getEmail());
        form.setName(member.getName());
        form.setCity(member.getCity());
        form.setStreet(member.getStreet());
        form.setZipcode(member.getZipcode());
        model.addAttribute("form", form);
        return "accountForm";
    }

    @PostMapping("/account")
    public String upDateMember(@ModelAttribute("form") MemberForm form) {
        form.setPassword(passwordEncoder.encode(form.getPassword()));
        memberService.updateMember(form);
        SecurityContextHolder.clearContext();
        return "loginForm";
    }

    @PostMapping("/account/delete")
    public String deleteMember(Principal principal) {
        memberService.deleteMember(principal.getName());
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }

}
