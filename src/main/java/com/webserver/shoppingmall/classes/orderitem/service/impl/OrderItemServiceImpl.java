package com.webserver.shoppingmall.classes.orderitem.service.impl;

import com.webserver.shoppingmall.classes.orderitem.repository.OrderItemRepository;
import com.webserver.shoppingmall.classes.orderitem.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
}
