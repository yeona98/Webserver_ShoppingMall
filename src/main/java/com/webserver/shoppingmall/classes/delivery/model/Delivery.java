package com.webserver.shoppingmall.classes.delivery.model;

import com.webserver.shoppingmall.classes.member.model.Address;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Delivery extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    private String status;

    @Embedded
    private Address address;

    @Builder
    public Delivery(String status, Address address) {
        this.status = status;
        this.address = address;
    }
}
