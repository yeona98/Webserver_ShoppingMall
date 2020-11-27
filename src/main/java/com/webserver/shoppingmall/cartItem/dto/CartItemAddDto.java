package com.webserver.shoppingmall.cartItem.dto;

import com.webserver.shoppingmall.cartItem.model.CartItem;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartItemAddDto {

    private Long itemId;
    private Long cartId;
    private int orderPrice;
    private int count;

    @Builder
    public CartItemAddDto(Long itemId, Long cartId, int orderPrice, int count) {
        this.itemId = itemId;
        this.cartId = cartId;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public CartItem toCartItemEntity() {
        return CartItem.builder()
                .orderPrice(orderPrice)
                .count(count)
                .build();
    }
}
