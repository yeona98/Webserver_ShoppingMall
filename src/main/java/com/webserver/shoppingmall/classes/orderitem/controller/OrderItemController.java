package com.webserver.shoppingmall.classes.orderitem.controller;

import com.webserver.shoppingmall.classes.orderitem.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderItemController {
    private final OrderItemService orderItemService;
}
