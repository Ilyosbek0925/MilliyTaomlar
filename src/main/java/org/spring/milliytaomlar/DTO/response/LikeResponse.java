package org.spring.milliytaomlar.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LikeResponse {
    private Integer id;
    private List<MenuResponse> menu;
    private UserResponse user;
}
