package org.spring.milliytaomlar.controller;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.ReservationRequest;
import org.spring.milliytaomlar.DTO.response.ReservationResponse;
import org.spring.milliytaomlar.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {
private final ReservationService service;
@PostMapping
    public ResponseEntity<ReservationResponse> addReservation(@RequestBody ReservationRequest reservationRequest) {
ReservationResponse response=service.addReservation(reservationRequest);

return ResponseEntity.ok(response);

}

@GetMapping
    public ResponseEntity<List<ReservationResponse>> getReservations() {
    List<ReservationResponse> responses=service.getReservations();

return ResponseEntity.ok(responses);
}



}
