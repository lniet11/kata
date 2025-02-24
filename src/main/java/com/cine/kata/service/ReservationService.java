package com.cine.kata.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.cine.kata.model.Reservation;
import com.cine.kata.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
    
    private final ReservationRepository reservationRepository;
    private final EmailService emailService;

    public Reservation createReservation(Reservation reservation) {
         // Enviar un correo electrónico al usuario
         String asunto = "Confirmación de Reserva";
         String cuerpo = "¡Gracias por tu reserva! Hemos confirmado tu asiento "
                 + reservation.getRoom().getId() + " en la sala " + reservation.getRoom().getName()
                 +"para la película" + reservation.getMovie().getTitle(); 
         
         
         emailService.enviarCorreo( asunto, cuerpo);
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

   // Eliminar una reserva por ID
   public boolean deleteReservationById(Long id) {
    // Verificar si la reserva existe
    if (reservationRepository.existsById(id)) {
        reservationRepository.deleteById(id);  // Eliminar la reserva
        return true;  // Si la reserva fue eliminada
    }
    return false;  // Si no se encontró la reserva
}


}
