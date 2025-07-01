package org.spring.milliytaomlar.DTO.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservationRequest {
    private String customerName;
    private String email;
    private String phone;
    private Integer numberOfPeople;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String specialQuestion;
    private Integer userId;


}
