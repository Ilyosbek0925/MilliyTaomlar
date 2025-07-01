package org.spring.milliytaomlar.DTO.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.spring.milliytaomlar.entity.Menu;
@Getter
@Setter
@NoArgsConstructor
public class BasketItemRequest {
    private Integer menuId;
    private Integer count;
}
