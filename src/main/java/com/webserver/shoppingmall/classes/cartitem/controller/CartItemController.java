package com.webserver.shoppingmall.classes.cartitem.controller;

import com.webserver.shoppingmall.classes.cartitem.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartItemController {
    private final CartItemService cartItemService;
}
