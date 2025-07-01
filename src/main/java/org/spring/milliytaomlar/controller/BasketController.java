package org.spring.milliytaomlar.controller;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.BasketRequest;
import org.spring.milliytaomlar.DTO.request.BasketUpdateRequest;
import org.spring.milliytaomlar.DTO.response.ApiResponse;
import org.spring.milliytaomlar.DTO.response.BasketItemResponse;
import org.spring.milliytaomlar.DTO.response.BasketResponse;
import org.spring.milliytaomlar.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService service;

    @PostMapping
    public ResponseEntity<BasketResponse> addBasket(@RequestBody BasketRequest basketRequest) {
        BasketResponse response = service.addBasket(basketRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<BasketItemResponse> updateBasket(@RequestBody BasketUpdateRequest basketUpdateRequest) {
        BasketItemResponse response = service.update(basketUpdateRequest);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{basketItemId}")
    public ResponseEntity<ApiResponse> deleteBasket(@PathVariable("basketItemId") Integer basketItemId) {
        service.delete(basketItemId);
        return ResponseEntity.ok(new ApiResponse(LocalDateTime.now(), "deleted successfully", HttpStatus.OK));
    }


}
