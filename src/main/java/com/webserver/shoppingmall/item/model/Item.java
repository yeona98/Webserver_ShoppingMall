package com.webserver.shoppingmall.item.model;

import com.webserver.shoppingmall.item.payload.ItemUpdateRequestDto;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;
    private String pictureURL;

    public static enum Category {
        OUTERS, TOPS, SHIRTS, SKIRTS, PANTS, SHOES, BAGS
    }

    @Builder
    public Item(Long id, String name, int price, int stockQuantity, Category category, String description, String pictureURL) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.description = description;
        this.pictureURL = pictureURL;
    }

    public Item update(ItemUpdateRequestDto payload) {
        this.name = payload.getName();
        this.price = payload.getPrice();
        this.stockQuantity = payload.getStockQuantity();
        this.category = payload.getCategory();
        this.description = payload.getDescription();
//        this.pictureURL = payload.getPicture();

        return this;
    }


}
