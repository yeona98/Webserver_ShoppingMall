package com.webserver.shoppingmall.classes.order.service.impl;

import com.webserver.shoppingmall.classes.order.repository.OrderRepository;
import com.webserver.shoppingmall.classes.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class  OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
}
