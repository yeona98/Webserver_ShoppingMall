package com.webserver.shoppingmall.order.service.impl;

import com.webserver.shoppingmall.ShoppingMallApplicationTests;
import com.webserver.shoppingmall.member.model.Address;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.order.model.Delivery;
import com.webserver.shoppingmall.order.model.Order;
import com.webserver.shoppingmall.order.repository.DeliveryRepository;
import com.webserver.shoppingmall.order.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest extends ShoppingMallApplicationTests {
    @Autowired
    OrderRepository orderRepository;
    MemberRepository memberRepository;
    DeliveryRepository deliveryRepository;

    @AfterEach
    void deleteAll() {
        orderRepository.deleteAll();
        memberRepository.deleteAll();
        deliveryRepository.deleteAll();
    }

    @Test
    void order_register_test() {
        // given
        String status = "status";

        String name = "name";
        String email = "email@gmail.com";
        String password = "password";
        String city = "city";
        String street = "street";
        String zipcode = "zipcode";

//        Member member = new Member(name,
//                email,
//                password,
//                new Address(city, street, zipcode);

//        Member member = new Member(name, email, password);
//
//        Member resultMember = memberRepository.saveAndFlush(member);
//
//        Delivery delivery = new Delivery(status, city, street, zipcode);
//
//        Delivery resultDelivery = deliveryRepository.saveAndFlush(delivery);
//
//        // when
//        Order result = orderRepository.saveAndFlush(new Order(status, member, delivery));
//
//        // then
//        System.out.println(result.getId());
//
//        assertNotNull(result);
//        assertEquals(status, result.getStatus());
//        assertEquals(name, result.getMember().getName());
//        assertEquals(email, result.getMember().getEmail());
//        assertEquals(password, result.getMember().getPassword());

    }
}