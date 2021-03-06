package com.webserver.shoppingmall.order.model;

import com.webserver.shoppingmall.member.model.Address;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Embeddable
public class Delivery {

    private String status;
    private String city;
    private String street;
    private String zipcode;

    @Builder
    public Delivery(String status, String city, String street, String zipcode) {
        this.status = status;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
