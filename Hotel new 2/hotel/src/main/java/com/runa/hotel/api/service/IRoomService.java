package com.runa.hotel.api.service;

import java.util.List;

import com.runa.hotel.api.dto.RoomDto;

public interface IRoomService {

    List<RoomDto> getAllRooms();
    
    RoomDto addRoom(RoomDto dto);

    RoomDto getRoomById(Long id);

    void updateRoom(Long id, RoomDto dto);

    void deleteRoomById(Long id);
}