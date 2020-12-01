package com.webserver.shoppingmall.cart.controller;

import com.webserver.shoppingmall.cart.dto.CartRegisterRequestDto;
import com.webserver.shoppingmall.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;

    @PostMapping("cart")
    public Long addItem(@RequestBody @Valid final CartRegisterRequestDto payload) {
        return cartService.addItem(payload);
    }
}
