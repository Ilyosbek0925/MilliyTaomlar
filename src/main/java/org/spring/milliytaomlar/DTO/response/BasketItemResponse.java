package org.spring.milliytaomlar.DTO.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.spring.milliytaomlar.entity.Menu;
@Builder
@Getter
@Setter
public class BasketItemResponse {
    private Integer basketItemId;
    private Menu menu;
    private Integer count;


}
