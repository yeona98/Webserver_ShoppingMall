package com.webserver.shoppingmall.cart.service.impl;

import com.webserver.shoppingmall.cart.dto.CartRegisterRequestDto;
import com.webserver.shoppingmall.cart.repository.CartItemRepository;
import com.webserver.shoppingmall.cart.repository.CartRepository;
import com.webserver.shoppingmall.cart.service.CartService;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ItemRepository itemRepository;

    @Override
    public Long addItem(final CartRegisterRequestDto payload) {
        Item item = itemRepository.findById(payload.getItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", payload.getItemId()));
        return cartRepository.getOne(payload.getItemId()).getId();
    }
}
