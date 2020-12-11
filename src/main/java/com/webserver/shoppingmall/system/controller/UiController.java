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

    @GetMapping("/register")
    public String getRegisterForm() {
        return "registerForm";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "loginForm";
    }

    @GetMapping("/test")
    public String test() {
        return "authpage";
    }

    @GetMapping("/account")
    public String upDateMemberForm(Model model, Principal principal) {
        Member member = memberService.getMemberByEmail(principal.getName());
        MemberForm form = new MemberForm(
                member.getId(),
                member.getEmail(),
                member.getName(),
                member.getPassword(),
                member.getCity(),
                member.getStreet(),
                member.getZipcode());
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
