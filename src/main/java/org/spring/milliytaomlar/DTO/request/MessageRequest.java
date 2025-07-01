package org.spring.milliytaomlar.DTO.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class MessageRequest {
    private String name;
    private String theme;
    private String phoneNumber;
    private String email;
    private Integer userId;
    private String message;

}
