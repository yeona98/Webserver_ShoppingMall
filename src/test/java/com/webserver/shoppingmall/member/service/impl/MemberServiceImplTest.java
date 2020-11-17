package com.webserver.shoppingmall.member.service.impl;

import com.webserver.shoppingmall.ShoppingMallApplicationTests;
import com.webserver.shoppingmall.cart.model.Cart;
import com.webserver.shoppingmall.cart.repository.CartRepository;
import com.webserver.shoppingmall.member.model.Address;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest extends ShoppingMallApplicationTests {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    CartRepository cartRepository;

    @AfterEach
    void deleteAll() {
        memberRepository.deleteAll();
        cartRepository.deleteAll();
        System.out.println("delete All");
    }

    @Transactional
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
        Member member = memberRepository.save(new Member(
                name,
                email,
                password,
                new Address(city, street, zipcode))
        );

        Cart cart = cartRepository.save(Cart.builder().member(member).build());
        
        // then
        assertNotNull(member);
        assertEquals(name, member.getName());
        assertEquals(email, member.getEmail());
        assertEquals(password, member.getPassword());
        assertNotNull(member.getAddress());
        assertEquals(city, member.getAddress().getCity());
        assertEquals(street, member.getAddress().getStreet());
        assertEquals(zipcode, member.getAddress().getZipcode());

        assertNotNull(cart);
        assertEquals(member, cart.getMember());
        
    }
}