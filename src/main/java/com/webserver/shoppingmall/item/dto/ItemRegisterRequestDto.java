package com.webserver.shoppingmall.item.dto;

import com.webserver.shoppingmall.item.model.Category;
import com.webserver.shoppingmall.item.model.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemRegisterRequestDto {
    private String name;
    private int price;
    private int stockQuantity;
    private Category category;

    @Builder
    public ItemRegisterRequestDto(String name, int price, int stockQuantity, Category category) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .category(category)
                .build();
    }
}
