package com.webserver.shoppingmall.member.service.impl;

import com.webserver.shoppingmall.member.dto.MemberRegisterDto;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceImplTest {

    @Autowired
    MemberServiceImpl memberService;
    @Autowired
    MemberRepository memberRepository;
    MemberRegisterDto registerDto;
    @Test
    public void 회원가입() throws Exception {
        String name = "Kim";
        String email = "123@123";
        String password = "123";
        final MemberRegisterDto dto = new MemberRegisterDto(email, name, password);
    }

    @Test
    public void 중복_회원_예외() throws Exception {

    }

}