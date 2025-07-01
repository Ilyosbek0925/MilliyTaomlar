package org.spring.milliytaomlar.DTO.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MenuRequest {
    private String name;
    private String description;
    private double price;
    private List<String> ingredients;
    private LocalTime preparationTime;
    private double calories;
}
