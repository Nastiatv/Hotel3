package com.runa.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runa.hotel.api.dto.RoomHistoryDto;
import com.runa.hotel.api.service.IRoomHistoryService;

@RestController
@RequestMapping(value = "/room_histories")
public class RoomHistoryController {

	@Autowired
	IRoomHistoryService roomHistoryService;

	@GetMapping
	public List<RoomHistoryDto> getAllRoomHistories() {
		return roomHistoryService.getAllRoomHistories();
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RoomHistoryDto addRoomHistory(@RequestBody RoomHistoryDto roomHistoryDto) {
		return roomHistoryService.addRoomHistory(roomHistoryDto);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateRoomHistory(@PathVariable Long id, @RequestBody RoomHistoryDto roomHistoryDto) {
		roomHistoryService.updateRoomHistory(id, roomHistoryDto);
	}

	@GetMapping(value = "/{id}")
	public RoomHistoryDto getRoomHistory(@PathVariable Long id) {
		return roomHistoryService.getRoomHistoryById(id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteRoomHistory(@PathVariable Long id) {
		roomHistoryService.deleteRoomHistoryById(id);
	}
}