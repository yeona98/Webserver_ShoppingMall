package com.webserver.shoppingmall.system.controller;

import com.webserver.shoppingmall.item.service.ItemService;
import com.webserver.shoppingmall.member.dto.MemberUpdateRequestDto;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UiController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/register")
    public String register() {
        return "registerForm";
    }

    @GetMapping("/account")
    public String upDateMemberForm(Model model, Principal principal) {
        Member member = memberService.getMemberByEmail(principal.getName());
        MemberUpdateRequestDto form = new MemberUpdateRequestDto(
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
    public String upDateMember(@ModelAttribute("form") MemberUpdateRequestDto form) {
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

    @GetMapping("/admin")
    public String test(Model model) {
        List<Member> memberList = memberService.getAllMembers();
        model.addAttribute("members", memberList);
        return "admin";
    }

    @PostMapping("/admin/{memberId}/ban")
    public String banMember(@PathVariable Long memberId) {
        memberService.deleteMemberById(memberId);
        return "redirect:/admin";
    }

    @GetMapping("items")
    public String items() {
        return "items";
    }

    @GetMapping("add-item")
    public String addItem() {
        return "add-item";
    }

    @GetMapping("update-item/{id}")
    public String updateItem(@PathVariable("id") Long id) {
        return "update-item";
    }


    @GetMapping("/my-cart")
    public String getCart(){
        return "cart";
    }

}
