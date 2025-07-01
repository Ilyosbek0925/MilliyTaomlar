package org.spring.milliytaomlar.DTO.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class ReservationResponse {
    private Integer id;
    private Integer userId;
    private String customerName;
    private String email;
    private String phone;
    private Integer numberOfPeople;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String specialQuestion;



}
