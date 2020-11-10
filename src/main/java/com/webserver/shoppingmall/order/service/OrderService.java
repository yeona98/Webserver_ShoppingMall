package com.webserver.shoppingmall.order.service;

import com.webserver.shoppingmall.member.dto.MemberRegisterRequestDto;
import com.webserver.shoppingmall.order.dto.OrderRegisterRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Long register(OrderRegisterRequestDto payload);
}
