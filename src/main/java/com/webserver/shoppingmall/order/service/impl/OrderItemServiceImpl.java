package com.webserver.shoppingmall.order.service.impl;

import com.webserver.shoppingmall.order.repository.OrderItemRepository;
import com.webserver.shoppingmall.order.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
}
