package com.webserver.shoppingmall.cart.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class CartRegisterRequestDto {
    @NotNull
    private final Long itemId;
}
