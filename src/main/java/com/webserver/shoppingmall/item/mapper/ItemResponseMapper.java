package com.webserver.shoppingmall.item.mapper;

import com.webserver.shoppingmall.item.model.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemResponseMapper {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private Item.Category category;
    private String description;
    private String picUrl;

    @Builder
    public ItemResponseMapper(Long id, String name, int price, int stockQuantity, Item.Category category, String description, String picUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.description = description;
        this.picUrl = picUrl;
    }

    //itemEntity_to_ItemResponseMapper
    public static ItemResponseMapper of(final Item item) {
        return ItemResponseMapper.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .category(item.getCategory())
                .description(item.getDescription())
                .picUrl(item.getPictureURL())
                .build();
    }
}
