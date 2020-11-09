package com.webserver.shoppingmall.cart.model;

import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class CartItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    private int orderPrice;
    private int count;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    public CartItem(int orderPrice, int count, Cart cart, Item item) {
        this.orderPrice = orderPrice;
        this.count = count;
        this.cart = cart;
        this.item = item;
    }
}
