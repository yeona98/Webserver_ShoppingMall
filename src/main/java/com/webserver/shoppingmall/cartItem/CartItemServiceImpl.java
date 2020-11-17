package com.webserver.shoppingmall.cartItem;

import com.webserver.shoppingmall.item.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;

    @Override
    @Transactional
    public Long addItemToCart(final CartItemAddDto payload) {
        final Optional<CartItem> cartItem = cartItemRepository.findById(payload.getItemId());

        return cartItemRepository.save(payload.toCartItemEntity()).getId();
    }
}
