package com.webserver.shoppingmall.cart.service;

import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.member.model.Member;

public interface CartService {
    Long saveItem(final Item item, final Member member);
}
