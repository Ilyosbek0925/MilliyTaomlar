package org.spring.milliytaomlar.DTO.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasketUpdateRequest {
    private Integer basketItemId;
    private Integer count;
}
