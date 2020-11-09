package com.webserver.shoppingmall.order.model;

import com.webserver.shoppingmall.member.model.Address;
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
    private String city;
    private String street;
    private String zipcode;

    @Builder
    public Delivery(Long id, String status, String city, String street, String zipcode) {
        this.id = id;
        this.status = status;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
