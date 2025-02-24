package com.cine.kata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cine.kata.model.Room;
import com.cine.kata.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {
    
    private final RoomRepository roomRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room updateRoom(Long id, Room room) {
        if (roomRepository.existsById(id)) {
            room.setId(id);
            return roomRepository.save(room);
        }
        return null;
    }

    public boolean deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
