package org.spring.milliytaomlar.mapper;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.RegisterRequest;
import org.spring.milliytaomlar.DTO.response.UserResponse;
import org.spring.milliytaomlar.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterMapper {
private final PasswordEncoder passwordEncoder;

    public User toUser(RegisterRequest request) {
        User user=new User();
        user.setFullName(request.getFullName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        return user;
    }

    public UserResponse toRegisterResponse(User save) {
        return UserResponse.builder()
                .id(save.getId())
                .email(save.getEmail())
                .phoneNumber(save.getPhoneNumber())
                .fullName(save.getFullName())
                .build();
    }
}
