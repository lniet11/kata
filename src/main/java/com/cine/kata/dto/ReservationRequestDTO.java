package com.cine.kata.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {
    private Long id;             // ID de la reserva
    private Long movieId;         // ID de la película
    private Long roomId;          // ID de la sala
    private Date schedule;        // Horario de la función
    private String seats;         // Asientos reservados, separados por coma (ej. "A1, A2, B1")

}
