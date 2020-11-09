package com.webserver.shoppingmall.classes.order.model;

import com.webserver.shoppingmall.classes.delivery.model.Delivery;
import com.webserver.shoppingmall.classes.member.model.Member;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @CreatedDate
    private LocalDateTime orderDate;

    @Builder
    public Order(String status, Member member, Delivery delivery) {
        this.status = status;
        this.member = member;
        this.delivery = delivery;
    }
}
