package org.spring.milliytaomlar.mapper;

import org.spring.milliytaomlar.DTO.request.MenuRequest;
import org.spring.milliytaomlar.DTO.response.MenuResponse;
import org.spring.milliytaomlar.entity.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {

    public Menu toMenu(MenuRequest menuRequest) {
        Menu menu = new Menu();
        menu.setCalories(menuRequest.getCalories());
        menu.setDescription(menuRequest.getDescription());
        menu.setIngredients(menuRequest.getIngredients());
        menu.setName(menuRequest.getName());
        menu.setPrice(menuRequest.getPrice());
        menu.setPreparationTime(menuRequest.getPreparationTime());
        return menu;
    }

    public MenuResponse toMenuResponse(Menu save) {
        return MenuResponse.builder()
                .id(save.getId())
                .name(save.getName())
                .description(save.getDescription())
                .calories(save.getCalories())
                .ingredients(save.getIngredients())
                .preparationTime(save.getPreparationTime())
                .photoDownload(save.getPhotoDownload())
                .price(save.getPrice())
                .build();
    }
}
