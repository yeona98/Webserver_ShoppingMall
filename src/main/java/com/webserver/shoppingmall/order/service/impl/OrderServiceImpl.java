package com.webserver.shoppingmall.order.service.impl;

import com.webserver.shoppingmall.order.repository.OrderRepository;
import com.webserver.shoppingmall.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class  OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
}
