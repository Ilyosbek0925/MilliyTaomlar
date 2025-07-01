package org.spring.milliytaomlar.controller;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.MenuRequest;
import org.spring.milliytaomlar.DTO.response.MenuResponse;
import org.spring.milliytaomlar.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService service;

    @PostMapping
    public ResponseEntity<MenuResponse> menu(@RequestPart MenuRequest menuRequest, @RequestPart MultipartFile file) {
        MenuResponse response = service.addMenu(menuRequest,file);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuResponse> getMenu(@PathVariable Integer id,@RequestParam MenuRequest menuRequest) {
        MenuResponse response=service.getMenu(menuRequest,id);
        return ResponseEntity.ok(response);
    }






}
