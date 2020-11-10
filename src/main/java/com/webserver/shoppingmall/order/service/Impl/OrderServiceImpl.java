package com.webserver.shoppingmall.order.service.Impl;

import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.order.repository.OrderRepository;
import com.webserver.shoppingmall.order.service.OrderService;
import com.webserver.shoppingmall.orderItem.model.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    @Override
    public Long order(Long memberId, Long itemId, Long count) {
        // 엔티티 조회
        Member member = memberRepository.getOne(memberId);
        Item item = itemRepository.getOne(itemId);



        return 1L;
    }
}
