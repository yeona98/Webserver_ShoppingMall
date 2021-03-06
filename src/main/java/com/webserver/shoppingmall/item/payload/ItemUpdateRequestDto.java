package com.webserver.shoppingmall.item.payload;

import com.webserver.shoppingmall.item.model.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class ItemUpdateRequestDto {
    private String name;
    private int price;
    private int stockQuantity;
    private Item.Category category;
    private String description;
    private MultipartFile picture;

    @Builder
    public ItemUpdateRequestDto(String name,
                                int price,
                                int stockQuantity,
                                Item.Category category,
                                String description,
                                MultipartFile picture) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.description = description;
        this.picture = picture;
    }
}
