package org.spring.milliytaomlar.controller;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.LoginRequest;
import org.spring.milliytaomlar.DTO.request.RegisterRequest;
import org.spring.milliytaomlar.DTO.response.UserResponse;
import org.spring.milliytaomlar.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService service;
@Autowired
 AuthenticationManager authenticationManager;
    @PostMapping("register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        UserResponse response = service.register(request);
        return ResponseEntity.ok(response);
    }
@PostMapping("login")
    public ResponseEntity<String>login(@RequestBody LoginRequest request) {
        String token = service.login(request,authenticationManager);
return ResponseEntity.ok(token);

    }

}
