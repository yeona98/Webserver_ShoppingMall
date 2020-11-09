package com.webserver.shoppingmall.order.controller;

import com.webserver.shoppingmall.order.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderItemController {
    private final OrderItemService orderItemService;
}
