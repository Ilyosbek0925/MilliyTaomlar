package org.spring.milliytaomlar.repository;

import org.spring.milliytaomlar.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
