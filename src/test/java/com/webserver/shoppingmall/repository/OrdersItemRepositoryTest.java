package com.webserver.shoppingmall.repository;

import com.webserver.shoppingmall.ShoppingMallApplicationTests;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.member.model.Address;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.order.repository.OrderItemRepository;
import com.webserver.shoppingmall.order.repository.OrderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersItemRepositoryTest extends ShoppingMallApplicationTests {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    public void 멤버생성() {
        //given
        //when
        Member resultMember = memberRepository.save(Member.builder().
                                                            name("name").
                                                            email("email").
                                                            password("password").
                                                            address(Address.builder().
                                                                    city("city").
                                                                    street("street").
                                                                    zipcode("zipcode").build()).build());
//        Item resultItem = itemRepository.save(Item.builder().
//                                                    name("name").
//                                                    price(10000).
//                                                    stockQuantity(10).
//                                                    category());
//
//        Order resultOrder = orderRepository.save(Order.builder().
//                member(resultMember).
//                build());
//        OrderItem resultOrderItem = orderItemRepository.save(OrderItem.builder().
//                order(resultOrder).
//                item(resultItem).
//                build());

        //then


    }

}
