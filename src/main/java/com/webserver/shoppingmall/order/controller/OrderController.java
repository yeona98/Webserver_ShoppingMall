package com.webserver.shoppingmall.order.controller;

import com.webserver.shoppingmall.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;
}
