package org.spring.milliytaomlar.service;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.ReservationRequest;
import org.spring.milliytaomlar.DTO.response.ReservationResponse;
import org.spring.milliytaomlar.entity.Reservation;
import org.spring.milliytaomlar.mapper.ReservationMapper;
import org.spring.milliytaomlar.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    private final ReservationMapper mapper;
    private final ReservationRepository reservationRepository;

    public ReservationResponse addReservation(ReservationRequest reservationRequest) {
        Reservation reservation = mapper.toReservation(reservationRequest);
        Reservation save = repository.save(reservation);
        return mapper.toReservationResponse(save);
    }


    public List<ReservationResponse> getReservations() {
        List<Reservation> all = reservationRepository.findAll();
        return all.stream().map(mapper::toReservationResponse).collect(Collectors.toList());
    }


}
