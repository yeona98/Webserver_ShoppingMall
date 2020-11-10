package com.webserver.shoppingmall.item.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private int price;
    private int stockQuantity;
    private String name;

    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;

    @Builder
    public Item(int price, int stockQuantity, String name) {
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.name = name;
    }
}
