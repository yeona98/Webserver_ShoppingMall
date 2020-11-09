package com.webserver.shoppingmall.member.service.impl;

import com.webserver.shoppingmall.ShoppingMallApplicationTests;
import com.webserver.shoppingmall.member.model.Address;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest extends ShoppingMallApplicationTests {
    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    void deleteAll() {
        memberRepository.deleteAll();
    }

    @Test
    void member_register_test() {
        // given
        String name = "name";
        String email = "email@gmail.com";
        String password = "password";
        String city = "city";
        String street = "street";
        String zipcode = "zipcode";

        // when
        Member result = memberRepository.save(new Member(
                name,
                email,
                password,
                new Address(city, street, zipcode))
        );

        // then
        System.out.println(result.getId());

        assertNotNull(result);
        assertEquals(name, result.getName());
        assertEquals(email, result.getEmail());
        assertEquals(password, result.getPassword());
        assertNotNull(result.getAddress());
        assertEquals(city, result.getAddress().getCity());
        assertEquals(street, result.getAddress().getStreet());
        assertEquals(zipcode, result.getAddress().getZipcode());

    }
}