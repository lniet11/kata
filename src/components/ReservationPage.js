import React, { useState } from 'react';
import axios from 'axios';
import MovieList from './MovieList';
import RoomList from './RoomList';
import '../styles/ReservationPage.css';
function ReservationPage() {
    const [selectedMovie, setSelectedMovie] = useState(null);
    const [selectedRoom, setSelectedRoom] = useState(null);
    const [seats, setSeats] = useState(0);

    const handleReservation = () => {
        if (!selectedMovie || !selectedRoom || seats <= 0) {
            alert('Please select a movie, room, and seats.');
            return;
        }

        const reservation = {
            movieId: selectedMovie.id,
            roomId: selectedRoom.id,
            schedule: new Date().toISOString(),  // Example schedule, you may modify it
            seats
        };

        axios.post('http://localhost:8080/api/reservations', reservation)
            .then(response => {
                alert('Reservation successful!');
            })
            .catch(error => {
                alert('Error making reservation');
            });
    };

    return (
        <div>
            <h1>Reservation Page</h1>
            <MovieList onSelectMovie={setSelectedMovie} />
            <RoomList onSelectRoom={setSelectedRoom} />
            <input
                type="number"
                value={seats}
                onChange={(e) => setSeats(e.target.value)}
                placeholder="Enter number of seats"
            />
            <button onClick={handleReservation}>Reserve</button>
        </div>
    );
}

export default ReservationPage;
