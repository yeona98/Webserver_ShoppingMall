package com.webserver.shoppingmall.cartItem.controller;

import com.webserver.shoppingmall.cartItem.dto.CartItemAddDto;
import com.webserver.shoppingmall.cartItem.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping(value = "item/{itemId}/add/{cartId}")
    public ResponseEntity<Long> addItemToCart(@RequestBody CartItemAddDto payload,
    @PathVariable("itemId") Long itemId, @PathVariable("cartId") Long cartId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cartItemService.addItemToCart(payload));
    }
}
