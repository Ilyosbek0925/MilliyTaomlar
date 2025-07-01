package org.spring.milliytaomlar.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.aspectj.bridge.Message;
import org.spring.milliytaomlar.DTO.request.MessageRequest;
import org.spring.milliytaomlar.DTO.response.MessageResponse;
import org.spring.milliytaomlar.entity.Messages;
import org.spring.milliytaomlar.mapper.MessageMapper;
import org.spring.milliytaomlar.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {
private final MessageRepository repository;
private final MessageMapper mapper;


    public MessageResponse addMessage(MessageRequest messageRequest) {
        Messages message=mapper.toMessage(messageRequest);
        Messages save = repository.save(message);
        return mapper.toMessageResponse(save);
    }

    public List<MessageResponse> findAll() {
        List<Messages> all = repository.findAll();
        return all.stream().map(mapper::toMessageResponse).collect(Collectors.toList());

    }
}
