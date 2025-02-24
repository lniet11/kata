import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../styles/ReservationList.css'; // Importar los estilos del componente

function ReservationList() {
    const [reservations, setReservations] = useState([]);

    useEffect(() => {
        // Obtener todas las reservas desde la API
        axios.get('http://localhost:8080/api/reservations')
            .then(response => {
                setReservations(response.data);
            })
            .catch(error => {
                console.error("There was an error fetching the reservations!", error);
            });
    }, []);

    return (
        <div className="reservation-container">
            <h2>Reservations</h2>
            {reservations.length === 0 ? (
                <p>No reservations made yet.</p>
            ) : (
                <ul>
                    {reservations.map((reservation) => (
                        <li key={reservation.id}>
                            <h3>{`Movie: ${reservation.movieId} - Room: ${reservation.roomId}`}</h3>
                            <p>{`Schedule: ${reservation.schedule}`}</p>
                            <p>{`Seats: ${reservation.seats}`}</p>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default ReservationList;
