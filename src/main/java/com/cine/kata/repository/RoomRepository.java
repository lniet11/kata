package com.cine.kata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cine.kata.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
