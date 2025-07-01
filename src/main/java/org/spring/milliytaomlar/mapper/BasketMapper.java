package org.spring.milliytaomlar.mapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.BasketRequest;
import org.spring.milliytaomlar.DTO.response.BasketResponse;
import org.spring.milliytaomlar.entity.Basket;
import org.spring.milliytaomlar.entity.BasketItem;
import org.spring.milliytaomlar.repository.BasketItemRepository;
import org.spring.milliytaomlar.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BasketMapper {
    private final BasketItemMapper mapper;
    private final UserRepository userRepository;
    private final BasketItemMapper basketItemMapper;

    public Basket toBasket(BasketRequest basketRequest) {

        List<BasketItem> basketItem = mapper.toBasketItem(basketRequest.getBasketItems());

        Basket basket = new Basket();
        basket.setBasketItems(basketItem);
        basket.setUser(userRepository.findById(basketRequest.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found")));

        return basket;


    }

    public BasketResponse toBasketResponse(Basket basket) {
        return BasketResponse.builder()
                .basketItems(basketItemMapper.toBasketItemResponse(basket.getBasketItems()))
                .userId(basket.getUser().getId())
                .build();

    }
}
