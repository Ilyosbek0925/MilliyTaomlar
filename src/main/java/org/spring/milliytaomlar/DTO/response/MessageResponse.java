package org.spring.milliytaomlar.DTO.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MessageResponse {
private Integer messageId;
private String message;
    private String name;
    private String theme;
    private String phoneNumber;
    private String email;
    private Integer userId;

}
