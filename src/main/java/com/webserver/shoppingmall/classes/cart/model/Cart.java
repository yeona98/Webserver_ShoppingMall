package com.webserver.shoppingmall.classes.cart.model;

import com.webserver.shoppingmall.classes.member.model.Member;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Cart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Cart(Long id, String status, Member member) {
        this.id = id;
        this.status = status;
        this.member = member;
    }
}
