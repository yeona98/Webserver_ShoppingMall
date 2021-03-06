package com.webserver.shoppingmall.cart.model;

import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Cart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Cart(Long id, Member member) {
        this.id = id;
        this.member = member;
    }

    // LOGIC

    public void addMember(Member member) {
        this.member = member;
        member.addCart(this);
    }
}
