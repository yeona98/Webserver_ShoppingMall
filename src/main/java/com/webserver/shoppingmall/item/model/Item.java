package com.webserver.shoppingmall.item.model;

import com.webserver.shoppingmall.cartItem.CartItem;
import com.webserver.shoppingmall.item.exception.NotEnoughStockException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private int price;
    private int stockQuantity;
    private String name;
    private String description;
    private String pic_url;

    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    @Builder
    public Item(int price, int stockQuantity, String name, String description, String pic_url, ItemCategory itemCategory) {
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.name = name;
        this.description = description;
        this.pic_url = pic_url;
        this.itemCategory = itemCategory;
    }

    //== 비즈니스 로직 ==//
    // stock 증가
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    // stock 감소
    public void removeStock(int quantity) {
        int restStock = (this.stockQuantity - quantity);
        if(restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
