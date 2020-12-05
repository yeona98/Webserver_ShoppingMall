package com.webserver.shoppingmall.member.service.impl;


import com.webserver.shoppingmall.member.dto.MemberRegisterDto;
import com.webserver.shoppingmall.member.exception.ResourceDuplicatedException;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.model.MemberDetails;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long registerMember(final MemberRegisterDto payload) {
        final Optional<Member> member =  memberRepository.findByEmail(payload.getEmail());
        if (member.isPresent())
            throw new ResourceDuplicatedException("member","email", payload.getEmail());

        return memberRepository.save(payload.toMemberEntity()).getId();
    }

    @Override
    @Transactional
    public void updateMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public Long deleteMember(String email) {
        Member member = memberRepository.findMemberByEmail(email);
        Long id = member.getId();
        System.out.println(id);
        memberRepository.delete(member);
        return id;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public boolean existEmail(String email) {
        return !memberRepository.existsByEmail(email);
    }

    @Override
    public Member getMemberByEmail(String email) {
        return memberRepository.findMemberByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberByEmail(email);

        List<GrantedAuthority> authorities = new ArrayList<>();
        if(member != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return new MemberDetails(member.getEmail(), member.getPassword(), authorities, member.getName());
    }

}
