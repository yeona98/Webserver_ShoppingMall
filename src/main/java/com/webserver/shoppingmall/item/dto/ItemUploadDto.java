package com.webserver.shoppingmall.item.dto;

import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.model.ItemCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemUploadDto {
    private int price;
    private int stockQuantity;
    private String name;
    private String description;
    private String pic_url;
    private ItemCategory itemCategory;

    @Builder
    public ItemUploadDto(int price, int stockQuantity, String name, String description, String pic_url, ItemCategory itemCategory) {
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.name = name;
        this.description = description;
        this.pic_url = pic_url;
        this.itemCategory = itemCategory;
    }

    public Item toItemEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .description(description)
                .pic_url(pic_url)
                .itemCategory(itemCategory)
                .build();
    }
}
