package com.webserver.shoppingmall.order.service;

import com.webserver.shoppingmall.cart.model.Cart;
import com.webserver.shoppingmall.order.dto.OrderRegisterRequestDto;
import com.webserver.shoppingmall.order.model.Orders;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Orders register(OrderRegisterRequestDto payload, Long itemId);
    Long register(OrderRegisterRequestDto payload, Cart cart);
}
