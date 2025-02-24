import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../styles/RoomList.css';
function RoomList({ onSelectRoom }) {
    const [rooms, setRooms] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/rooms')
            .then(response => {
                setRooms(response.data);
            });
    }, []);

    return (
        <div>
            <h2>Rooms</h2>
            <ul>
                {rooms.map(room => (
                    <li key={room.id} onClick={() => onSelectRoom(room)}>
                        {room.name} - Capacity: {room.capacity}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default RoomList;
