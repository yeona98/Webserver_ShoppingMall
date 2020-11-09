package com.webserver.shoppingmall.cart.controller;

import com.webserver.shoppingmall.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;
}
