package com.webserver.shoppingmall.order.service.impl;

import com.webserver.shoppingmall.cart.model.Cart;
import com.webserver.shoppingmall.cart.model.CartItem;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.order.dto.OrderRegisterRequestDto;
import com.webserver.shoppingmall.order.model.Orders;
import com.webserver.shoppingmall.order.model.OrderItem;
import com.webserver.shoppingmall.order.repository.OrderItemRepository;
import com.webserver.shoppingmall.order.repository.OrderRepository;
import com.webserver.shoppingmall.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class  OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    @Transactional
    public Orders register(OrderRegisterRequestDto payload, Long itemId){
        //원하는 아이템 아이디
        Item item = itemRepository.findById(itemId).get();
        OrderItem orderItem = OrderItem.builder().
                item(item).
                count(1).
                build();
        Orders orders = payload.toEntity();

        orders.getOrderItemList().add(orderItem);
        orderItemRepository.save(orderItem);
        return orderRepository.save(orders);
    }

    @Override
    public Long register(OrderRegisterRequestDto payload, Cart cart) {
        List<CartItem> cartItemList = cart.getCartItem();
        Orders orders = payload.toEntity();
        cartItemList.forEach(x ->
                orders.getOrderItemList().add(
                        orderItemRepository.save(
                                OrderItem.builder().
                                        count(x.getCount()).
                                        item(x.getItem()).
                                        orders(orders).
                                        build()
                        )
                )
        );
        return orderRepository.save(orders).getId();
    }
}
