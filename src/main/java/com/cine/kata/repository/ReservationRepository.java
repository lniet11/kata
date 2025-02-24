package com.cine.kata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.kata.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
