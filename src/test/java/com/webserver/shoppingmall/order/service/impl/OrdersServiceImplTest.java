package com.webserver.shoppingmall.order.service.impl;

import com.webserver.shoppingmall.ShoppingMallApplicationTests;
import com.webserver.shoppingmall.cart.model.Cart;
import com.webserver.shoppingmall.cart.repository.CartRepository;
import com.webserver.shoppingmall.item.model.Category;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.member.model.Address;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.order.model.OrderItem;
import com.webserver.shoppingmall.order.model.Orders;
import com.webserver.shoppingmall.order.repository.OrderItemRepository;
import com.webserver.shoppingmall.order.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

class OrdersServiceImplTest extends ShoppingMallApplicationTests {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    CartRepository cartRepository;

    @BeforeEach()
    void init() {
        String name = "name";
        String email = "email@gmail.com";
        String password = "password";
        String city = "city";
        String street = "street";
        String zipcode = "zipcode";

        String itemName = "aaa";
        int price = 10000;
        int stockQuantity = 5;


        Item item = Item.builder()
                .name(itemName)
                .price(price)
                .stockQuantity(stockQuantity)
                .category(Category.BAGS)
                .build();

        itemRepository.save(item);

        // when
        final Member member = memberRepository.save(new Member(
                name,
                email,
                password,
                new Address(city, street, zipcode))
        );

        cartRepository.save(Cart.builder().member(member).build());
    }

    @AfterEach
    void deleteAll() {
        memberRepository.deleteAll();
        itemRepository.deleteAll();
        orderItemRepository.deleteAll();
        orderRepository.deleteAll();
        System.out.println("delete");
    }

    @Transactional
    @Test
    void order_item() {
        //given
        Long requestMemberId = 1L;
        Long requestItemId = 1L;

        Member member = memberRepository.findById(requestMemberId).get();
        Item item = itemRepository.findById(requestItemId).get();
        Orders orders = orderRepository.save(Orders.builder().member(member).status("배송작업").build());

        OrderItem orderItem = orderItemRepository.save(OrderItem.builder()
                .orders(orders)
                .item(item)
                .count(10)
                .orderPrice(10000)
                .build());

        assertNotNull(orderItem);

    }

}