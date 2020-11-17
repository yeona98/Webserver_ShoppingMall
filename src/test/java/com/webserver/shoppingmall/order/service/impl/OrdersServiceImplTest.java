package com.webserver.shoppingmall.order.service.impl;

import com.webserver.shoppingmall.ShoppingMallApplicationTests;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.order.dto.OrderRegisterRequestDto;
import com.webserver.shoppingmall.order.model.Orders;
import com.webserver.shoppingmall.order.model.OrderItem;
import com.webserver.shoppingmall.order.repository.OrderItemRepository;
import com.webserver.shoppingmall.order.repository.OrderRepository;
import com.webserver.shoppingmall.order.service.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class OrdersServiceImplTest extends ShoppingMallApplicationTests {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
//    @Autowired
//    DeliveryRepository deliveryRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrderService orderService;

    @AfterEach
    void deleteAll() {
        orderRepository.deleteAll();
        orderItemRepository.deleteAll();
        memberRepository.deleteAll();
        itemRepository.deleteAll();
//        deliveryRepository.deleteAll();
    }

    @Test
    void order_register_test() {
        // given
        Member member = memberRepository.save(Member.builder().build()); //member 생성
        String name = "item";
        Item item = itemRepository.save(Item.builder().name(name).build()); //item 생성

        Orders orders = Orders.builder().member(member).build(); // member 지정된 Orders 생성
        OrderItem orderItem = OrderItem.builder().item(item).orders(orders).build(); // item과 order가 지정된 orderItem 생성
        orders.getOrderItemList().add(orderItem); // 오더에 오더 아이템 추가

        Orders result = orderService.register(OrderRegisterRequestDto.builder()
                .build(), item.getId());

        assertNotNull(result);
        assertEquals(name, result.getOrderItemList().get(0).getItem().getName());

        // given
//        String status = "status";
//
//        String name = "name";
//        String email = "email@gmail.com";
//        String password = "password";
//        String city = "city";
//        String street = "street";
//        String zipcode = "zipcode";

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