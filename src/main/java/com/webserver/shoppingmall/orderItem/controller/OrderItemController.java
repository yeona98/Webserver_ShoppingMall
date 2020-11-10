package com.webserver.shoppingmall.orderItem.controller;

import com.webserver.shoppingmall.orderItem.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderItemController {
    private final OrderItemService orderItemService;
}
