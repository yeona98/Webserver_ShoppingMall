package com.webserver.shoppingmall.cart.service.impl;

import com.webserver.shoppingmall.cart.repository.CartRepository;
import com.webserver.shoppingmall.cart.service.CartService;
import com.webserver.shoppingmall.cartItem.repository.CartItemRepository;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Override
    public Long saveItem(Item item, Member member) {
        return null;
    }
}
