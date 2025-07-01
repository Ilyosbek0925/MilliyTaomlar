package org.spring.milliytaomlar.mapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.spring.milliytaomlar.DTO.request.MessageRequest;
import org.spring.milliytaomlar.DTO.response.MessageResponse;
import org.spring.milliytaomlar.entity.Messages;
import org.spring.milliytaomlar.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageMapper {
    private final UserRepository userRepository;

    public Messages toMessage(MessageRequest messageRequest) {
        Messages messages = new Messages();
        messages.setEmail(messageRequest.getEmail());
        messages.setMessage(messageRequest.getMessage());
        messages.setName(messageRequest.getName());
        messages.setTheme(messageRequest.getTheme());
        messages.setPhoneNumber(String.valueOf(messageRequest.getPhoneNumber()));
        messages.setUser(userRepository.findById(messageRequest.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found")));
        return messages;

    }

    public MessageResponse toMessageResponse(Messages save) {
        return MessageResponse.builder()
                .messageId(save.getId())
                .message(save.getMessage())
                .name(save.getName())
                .theme(save.getTheme())
                .phoneNumber(save.getPhoneNumber())
                .userId(save.getUser().getId())
                .email(save.getEmail())
                .build();

    }
}
