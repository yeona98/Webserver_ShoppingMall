package com.webserver.shoppingmall.cart.service.impl;

import com.webserver.shoppingmall.ShoppingMallApplicationTests;
import com.webserver.shoppingmall.cart.model.Cart;
import com.webserver.shoppingmall.cart.model.CartItem;
import com.webserver.shoppingmall.cart.repository.CartItemRepository;
import com.webserver.shoppingmall.cart.repository.CartRepository;
import com.webserver.shoppingmall.item.model.Category;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.member.model.Address;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceImplTest extends ShoppingMallApplicationTests  {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    ItemRepository itemRepository;

    @BeforeEach
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
        cartRepository.deleteAll();
        memberRepository.deleteAll();
        cartItemRepository.deleteAll();
        itemRepository.deleteAll();
    }

    @Test
    void add_item_cart() {
        //given
        Long requestMemberId = 1L;
        Long requestItemId = 1L;

        Member member = memberRepository.findById(requestMemberId).get();
        Item item = itemRepository.findById(requestItemId).get();
        Cart cart = member.getCart();

        //when
        CartItem cartItem = cartItemRepository.save(CartItem.builder()
                .item(item)
                .cart(cart)
                .count(5)
                .orderPrice(50000)
                .build());

        //then
        assertNotNull(cartItem);
        assertEquals(cartItem.getCart(), cart);
        assertEquals(cartItem.getItem(), item);
        assertEquals(cart.getMember(), member);
        assertEquals(5, cartItem.getCount());
    }
}