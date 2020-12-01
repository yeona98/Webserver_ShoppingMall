package com.webserver.shoppingmall.order.service;

import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.member.model.Member;
import org.springframework.stereotype.Service;

public interface OrderService {
    Long orderItem(final Member member, final Item item);
}
