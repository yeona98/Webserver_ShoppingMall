package com.webserver.shoppingmall.orderItem.service.impl;

import com.webserver.shoppingmall.orderItem.repository.OrderItemRepository;
import com.webserver.shoppingmall.orderItem.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
}
