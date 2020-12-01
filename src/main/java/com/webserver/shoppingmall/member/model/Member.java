package com.webserver.shoppingmall.member.model;

import com.webserver.shoppingmall.cart.model.Cart;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Cart cart;

    @Embedded
    private Address address;

    public Member(String name, String email, String password, Address address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    @Builder
    public Member(Long id, String name, String email, String password, Cart cart, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = cart;
        this.address = address;
    }


    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
