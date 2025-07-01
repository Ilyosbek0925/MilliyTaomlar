package org.spring.milliytaomlar.mapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.ReservationRequest;
import org.spring.milliytaomlar.DTO.response.ReservationResponse;
import org.spring.milliytaomlar.entity.Reservation;
import org.spring.milliytaomlar.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationMapper {
private final UserRepository userRepository;

    public Reservation toReservation(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation();
        reservation.setReservationTime(reservationRequest.getReservationTime());
        reservation.setReservationDate(reservationRequest.getReservationDate());
        reservation.setCustomerName(reservationRequest.getCustomerName());
        reservation.setEmail(reservationRequest.getEmail());
        reservation.setPhone(reservationRequest.getPhone());
        reservation.setSpecialQuestion(reservationRequest.getSpecialQuestion());
        reservation.setNumberOfPeople(reservationRequest.getNumberOfPeople());
        reservation.setUser(userRepository.findById(reservationRequest.getUserId()).orElseThrow(() -> new EntityNotFoundException("User Not Found with the ID : "+reservationRequest.getUserId())));
        return reservation;
    }


    public ReservationResponse toReservationResponse(Reservation save) {
        return ReservationResponse.builder()
                .id(save.getId())
                .customerName(save.getCustomerName())
                .email(save.getEmail())
                .phone(save.getPhone())
                .specialQuestion(save.getSpecialQuestion())
                .reservationTime(save.getReservationTime())
                .reservationDate(save.getReservationDate())
                .numberOfPeople(save.getNumberOfPeople())
                .userId(save.getUser().getId())
                .build();
    }
}
