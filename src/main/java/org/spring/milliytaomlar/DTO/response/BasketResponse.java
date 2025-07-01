package org.spring.milliytaomlar.DTO.response;

import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.spring.milliytaomlar.entity.BasketItem;
import org.spring.milliytaomlar.entity.User;

import java.util.List;

@Getter
@Setter
@Builder
public class BasketResponse {
    private List<BasketItemResponse> basketItems;
    private Integer userId;
}
