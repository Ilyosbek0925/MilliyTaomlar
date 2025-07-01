package org.spring.milliytaomlar.DTO.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class LikeRequest {
    private Integer menuId;
    private Integer userId;
}