package org.spring.milliytaomlar.DTO.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class BasketRequest {
    private List<BasketItemRequest> basketItems;
    private Integer userId;

}
