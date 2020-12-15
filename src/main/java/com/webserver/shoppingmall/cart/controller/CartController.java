package com.webserver.shoppingmall.cart.controller;


import com.webserver.shoppingmall.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CartController {
    private final CartService cartService;
//
//    @GetMapping("/my-cart")
//    public String getMyCart() {
//        return "myCart";
//    }
}
