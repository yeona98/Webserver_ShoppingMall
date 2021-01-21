package com.webserver.shoppingmall.member.service.impl;

import com.webserver.shoppingmall.cart.model.Cart;
import com.webserver.shoppingmall.cart.repository.CartRepository;
import com.webserver.shoppingmall.member.dto.MemberRegisterRequestDto;
import com.webserver.shoppingmall.member.exception.ResourceDuplicatedException;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.dto.MemberUpdateRequestDto;
import com.webserver.shoppingmall.member.model.MemberDetails;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;

    @Override
    @Transactional
    public Long register(MemberRegisterRequestDto payload) {
        Member member = memberRepository.save(payload.toMemberEntity());
        Cart cart = cartRepository.save(Cart.builder().member(member).build());
        return memberRepository.save(payload.toMemberEntity()).getId();
    }

    @Override
    @Transactional
    public Long registerMember(final MemberRegisterRequestDto payload) {
        final Optional<Member> member =  memberRepository.findByEmail(payload.getEmail());
        if (member.isPresent())
            throw new ResourceDuplicatedException("member","email", payload.getEmail());

        return memberRepository.save(payload.toMemberEntity()).getId();
    }

    @Override
    @Transactional
    public void updateMember(MemberUpdateRequestDto payload) {
        Member member = memberRepository.findMemberById(payload.getId());
        if(member != null) {
            member.update(
                    payload.getName(),
                    payload.getEmail(),
                    payload.getPassword(),
                    payload.getCity(),
                    payload.getStreet(),
                    payload.getZipcode());
        }
    }

    @Override
    @Transactional
    public Long deleteMember(String email) {
        Member member = memberRepository.findMemberByEmail(email);
        Long id = member.getId();
        memberRepository.delete(member);
        return id;
    }

    @Override
    @Transactional
    public void deleteMemberById(Long id) {
        memberRepository.delete(memberRepository.findMemberById(id));
    }

    @Override
    public Member findMemberById(Long id) {
        return memberRepository.findMemberById(id);
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
            if(member.getName().equals("운영자")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            } else{
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return new MemberDetails(member.getEmail(), member.getPassword(), authorities, member.getName());
    }

}
