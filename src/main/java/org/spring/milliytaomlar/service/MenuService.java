package org.spring.milliytaomlar.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.MenuRequest;
import org.spring.milliytaomlar.DTO.response.DocumentResponse;
import org.spring.milliytaomlar.DTO.response.MenuResponse;
import org.spring.milliytaomlar.entity.Menu;
import org.spring.milliytaomlar.mapper.MenuMapper;
import org.spring.milliytaomlar.repository.MenuRepository;
import org.spring.milliytaomlar.service.impl.AwsStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuMapper mapper;
    private final MenuRepository repository;
    private final AwsStorageService awsStorageService;

    public MenuResponse addMenu(MenuRequest menuRequest, MultipartFile file) {
        DocumentResponse documentResponse = awsStorageService.uploadFile(file);
        Menu menu = mapper.toMenu(menuRequest);
        menu.setPhotoDownload(documentResponse.getDownloadUrl());
        Menu save = repository.save(menu);
        return mapper.toMenuResponse(save);
    }


    public MenuResponse getMenu(MenuRequest menuRequest,Integer id) {
        Menu menu = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Menu not found with id " + id));
        return mapper.toMenuResponse(menu);
    }
}
