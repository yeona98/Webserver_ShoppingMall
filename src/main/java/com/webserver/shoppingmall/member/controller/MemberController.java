package com.webserver.shoppingmall.member.controller;

import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.member.dto.MemberRegisterRequestDto;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.member.service.MemberService;
import com.webserver.shoppingmall.order.model.Orders;
import com.webserver.shoppingmall.order.model.OrderItem;
import com.webserver.shoppingmall.order.repository.OrderItemRepository;
import com.webserver.shoppingmall.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @PostMapping("member")
    public ResponseEntity<?> save(MemberRegisterRequestDto registerRequestDto){
        return new ResponseEntity<>(memberService.register(registerRequestDto), HttpStatus.OK);
    }

    @PostMapping("test")
    public void test(){ // order controller 에서 order 함수에 매개변수로 member와 item을 받음
        Member member = memberRepository.save(Member.builder().build()); // member 생성

        Item item = itemRepository.save(Item.builder().build()); // item 생성

        Orders orders = Orders.builder().member(member).build(); // member 지정된 order 생성

        OrderItem orderItem = OrderItem.builder().item(item).orders(orders).build(); // order, item 지정된 orderItem 생성

        //orders.getOrderItemList().add(orderItem); // order에 orderItem 추가

        orderRepository.save(orders);
        orderItemRepository.save(orderItem);

        System.out.println(orders);
        System.out.println(orderRepository.findAll());
    }
}
