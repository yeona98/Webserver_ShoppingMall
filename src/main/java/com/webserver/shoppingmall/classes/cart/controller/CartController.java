package com.webserver.shoppingmall.classes.cart.controller;

import com.webserver.shoppingmall.classes.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;
}
