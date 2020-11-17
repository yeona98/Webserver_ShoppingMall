package com.webserver.shoppingmall.order.service.impl;

import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class  OrderServiceImpl implements OrderService {

    @Override
    public Long orderItem(Member member, Item item) {
        return null;
    }
}
