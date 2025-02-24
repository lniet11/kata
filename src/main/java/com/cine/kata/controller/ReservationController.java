package com.cine.kata.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.kata.dto.ReservationRequestDTO;
import com.cine.kata.model.Movie;
import com.cine.kata.model.Reservation;
import com.cine.kata.model.Room;
import com.cine.kata.service.MovieService;
import com.cine.kata.service.ReservationService;
import com.cine.kata.service.RoomService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final MovieService movieService;  // Servicio para acceder a las películas
    private final RoomService roomService;    // Servicio para acceder a las salas

    // Crear una nueva reserva o actualizar una existente
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        // Buscar la película y la sala por los IDs proporcionados
        Optional<Movie> movieOpt = movieService.getMovieById(reservationRequestDTO.getMovieId());
        Optional<Room> roomOpt = roomService.getRoomById(reservationRequestDTO.getRoomId());

        // Verificar si la película y la sala existen
        if (!movieOpt.isPresent() || !roomOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Película o sala no encontrados
        }

        // Crear la entidad Reservation con los objetos Movie y Room encontrados
        Reservation reservation = new Reservation();
        reservation.setMovie(movieOpt.get());
        reservation.setRoom(roomOpt.get());
        reservation.setSchedule(reservationRequestDTO.getSchedule());
        reservation.setSeats(reservationRequestDTO.getSeats());
        
        // Guardar la reserva en la base de datos
        Reservation savedReservation = reservationService.createReservation(reservation);
        
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }
    // Método para actualizar una reserva
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody ReservationRequestDTO reservationRequestDTO) {
        // Buscar la reserva existente por ID
        Optional<Reservation> existingReservationOpt = reservationService.getReservationById(id);
        
        if (!existingReservationOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Si no se encuentra la reserva
        }
        
        // Buscar la película y la sala por sus IDs
        Optional<Movie> movieOpt = movieService.getMovieById(reservationRequestDTO.getMovieId());
        Optional<Room> roomOpt = roomService.getRoomById(reservationRequestDTO.getRoomId());

        if (!movieOpt.isPresent() || !roomOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Si la película o sala no existen
        }

        // Obtener la reserva existente
        Reservation existingReservation = existingReservationOpt.get();
        
        // Actualizar los campos de la reserva
        existingReservation.setMovie(movieOpt.get());
        existingReservation.setRoom(roomOpt.get());
        existingReservation.setSchedule(reservationRequestDTO.getSchedule());
        existingReservation.setSeats(reservationRequestDTO.getSeats());
        
        // Guardar la reserva actualizada
        Reservation updatedReservation = reservationService.createReservation(existingReservation);
        
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);  // Devolver la reserva actualizada
    }
    // Obtener una reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        
        if (!reservation.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Si no se encuentra la reserva
        }
        
        return new ResponseEntity<>(reservation.get(), HttpStatus.OK);  // Devolver la reserva
    }
     // Eliminar una reserva por ID
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
         // Verificar si la reserva existe
         boolean isDeleted = reservationService.deleteReservationById(id);
 
         if (!isDeleted) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Si no se encuentra la reserva
         }
 
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Eliminar correctamente, responder sin contenido (204)
     }
}
