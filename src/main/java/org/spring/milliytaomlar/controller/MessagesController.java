package org.spring.milliytaomlar.controller;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.MessageRequest;
import org.spring.milliytaomlar.DTO.response.MessageResponse;
import org.spring.milliytaomlar.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("message")
public class MessagesController {
    private final MessageService service;

    @PostMapping
    public ResponseEntity<MessageResponse> sendMessage(@RequestBody MessageRequest messageRequest) {
        MessageResponse response = service.addMessage(messageRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



}
