package org.spring.milliytaomlar.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Getter
@Setter
public class Reservation extends BaseEntity {
    private String customerName;
    private String email;
    private String phone;
    private Integer numberOfPeople;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String specialQuestion;
    @ManyToOne
    private User user;
}
