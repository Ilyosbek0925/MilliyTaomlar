package org.spring.milliytaomlar.mapper;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.BasketItemRequest;
import org.spring.milliytaomlar.DTO.response.BasketItemResponse;
import org.spring.milliytaomlar.entity.BasketItem;
import org.spring.milliytaomlar.repository.MenuRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BasketItemMapper {
    private final MenuRepository menuRepository;


    public List<BasketItem> toBasketItem(List<BasketItemRequest> basketItems) {
        return basketItems.stream().map(this::toBasketItem).collect(Collectors.toList());
    }
    public BasketItem toBasketItem(BasketItemRequest basketItemRequest) {
        BasketItem basketItem=new BasketItem();
        basketItem.setMenu(menuRepository.findById(basketItemRequest.getMenuId()).orElseThrow());
        basketItem.setCount(basketItemRequest.getCount());
        return basketItem;
    }



    public List<BasketItemResponse> toBasketItemResponse(List<BasketItem> items) {
    return items.stream().map(this::toBasketItemResponse).collect(Collectors.toList());

    }

    public BasketItemResponse toBasketItemResponse(BasketItem save) {
        return BasketItemResponse.builder()
                .count(save.getCount())
                .menu(save.getMenu())
                .build();
    }
}
