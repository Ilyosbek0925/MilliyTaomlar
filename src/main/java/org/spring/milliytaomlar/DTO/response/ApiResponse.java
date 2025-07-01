package org.spring.milliytaomlar.DTO.response;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@AllArgsConstructor
public class ApiResponse {
    private LocalDateTime time;
    private String message;
    private HttpStatus status;


}
