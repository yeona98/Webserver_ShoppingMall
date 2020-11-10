package com.webserver.shoppingmall.order.service;

public interface OrderService {
    Long order(Long memberId, Long itemId, Long count);
}
