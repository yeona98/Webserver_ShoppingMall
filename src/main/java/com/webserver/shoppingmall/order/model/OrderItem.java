package com.webserver.shoppingmall.order.model;

import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class OrderItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    private int orderPrice;
    private int count;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    public OrderItem(int orderPrice, int count, Order order, Item item) {
        this.orderPrice = orderPrice;
        this.count = count;
        this.order = order;
        this.item = item;
    }
}
