package com.runa.hotel.api.service;

import java.util.List;

import com.runa.hotel.api.dto.RoomHistoryDto;

public interface IRoomHistoryService {
	

		List<RoomHistoryDto> getAllRoomHistories();

		RoomHistoryDto addRoomHistory(RoomHistoryDto roomHistoryDto);

		RoomHistoryDto getRoomHistoryById(Long id);

		void deleteRoomHistoryById(Long id);

		void updateRoomHistory(Long id, RoomHistoryDto roomHistoryDto);

	}