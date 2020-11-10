package com.webserver.shoppingmall.member.service.impl;

import com.webserver.shoppingmall.member.dto.MemberRegisterDto;
import com.webserver.shoppingmall.member.exception.ResourceDuplicatedException;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final 인 녀석에 대해 constructor 자동 생성
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long registerMember(MemberRegisterDto payload) {
        final Optional<Member> member =  memberRepository.findByEmail(payload.getEmail());

        if (member.isPresent())
            throw new ResourceDuplicatedException("member","email", payload.getEmail());

        return memberRepository.save(payload.toMemberEntity()).getId();
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
