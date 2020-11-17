package com.webserver.shoppingmall.cartItem;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class CartItemAddDto {

    private Long itemId;
    private Long cartId;
    private int price;
    private int count;
    private String name;

    @Builder
    public CartItemAddDto(Long itemId, Long cartId, int price, int count, String name) {
        this.itemId = itemId;
        this.cartId = cartId;
        this.price = price;
        this.count = count;
        this.name = name;
    }

    public CartItem toCartItemEntity() {
        return CartItem.builder()
                .price(price)
                .count(count)
                .name(name)
                .build();
    }
}
