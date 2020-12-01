package com.webserver.shoppingmall.order.dto;

import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.order.model.Delivery;
import com.webserver.shoppingmall.order.model.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderRegisterRequestDto {
    private String status;
    private Member member;
    private Delivery delivery;

    @Builder
    public OrderRegisterRequestDto(String status, Member member, Delivery delivery) {
        this.status = status;
        this.member = member;
        this.delivery = delivery;
    }

    public Orders toEntity(){
        return Orders.builder().
                member(member).
                status(status).
                delivery(delivery).
                build();
    }
}
