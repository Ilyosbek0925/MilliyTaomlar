package org.spring.milliytaomlar.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.BasketRequest;
import org.spring.milliytaomlar.DTO.request.BasketUpdateRequest;
import org.spring.milliytaomlar.DTO.response.BasketItemResponse;
import org.spring.milliytaomlar.DTO.response.BasketResponse;
import org.spring.milliytaomlar.entity.Basket;
import org.spring.milliytaomlar.entity.BasketItem;
import org.spring.milliytaomlar.entity.User;
import org.spring.milliytaomlar.mapper.BasketItemMapper;
import org.spring.milliytaomlar.mapper.BasketMapper;
import org.spring.milliytaomlar.repository.BasketItemRepository;
import org.spring.milliytaomlar.repository.BasketRepository;
import org.spring.milliytaomlar.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketMapper mapper;
    private final UserRepository userRepository;
    private final BasketRepository repository;
    private final BasketItemMapper basketItemMapper;
    private final BasketMapper basketMapper;
    private final BasketItemRepository basketItemRepository;

    public BasketResponse addBasket(BasketRequest basketRequest) {
        Integer userId = basketRequest.getUserId();
        Basket basket = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found")).getBasket();
        if (basket == null) {
            Basket basketMapped = mapper.toBasket(basketRequest);
            Basket save = repository.save(basketMapped);
            return basketMapper.toBasketResponse(save);
        } else {
            basket.getBasketItems().addAll(basketItemMapper.toBasketItem(basketRequest.getBasketItems()));
            Basket save = repository.save(basket);
            return basketMapper.toBasketResponse(save);
        }


    }

    public BasketItemResponse update(BasketUpdateRequest basketUpdateRequest) {
        BasketItem basketItem = basketItemRepository.findById(basketUpdateRequest.getBasketItemId()).orElseThrow(() -> new EntityNotFoundException("Basket Item not found"));
        basketItem.setCount(basketUpdateRequest.getCount());
        BasketItem save = basketItemRepository.save(basketItem);
        return basketItemMapper.toBasketItemResponse(save);

    }

    public void delete(Integer basketItemId) {
        if (basketItemRepository.existsById(basketItemId)) {

            basketItemRepository.deleteById(basketItemId);
        }
        throw new EntityNotFoundException("Basket Item not found");

    }
}
