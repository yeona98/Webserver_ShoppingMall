package com.webserver.shoppingmall.cartItem;

import com.webserver.shoppingmall.cart.Cart;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class CartItem extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_id")
    private Long id;

    private String name;
    private int price;
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    public CartItem(int price, int count, String name) {
        this.price = price;
        this.count = count;
        this.name = name;
    }
}
