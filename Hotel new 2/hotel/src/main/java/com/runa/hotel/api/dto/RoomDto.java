package com.runa.hotel.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.runa.hotel.entities.Room;
import com.runa.hotel.enums.Status;

public class RoomDto extends ADto {

	private int capacity;
	private int dailyPrice;
	private Status status;
	private List<RoomHistoryDto> roomHistories;

	public static List<RoomDto> convertList(List<Room> entities) {
		List<RoomDto> rooms = new ArrayList<>();
		for (Room entity : entities) {
			RoomDto dto = new RoomDto();
			dto.setId(entity.getId());
			dto.setCapacity(entity.getCapacity());
			dto.setDailyPrice(entity.getDailyPrice());
			dto.setStatus(entity.getStatus());
			dto.setRoomHistories(RoomHistoryDto.convertList(entity.getRoomHistories()));
			rooms.add(dto);
		}
		return rooms;
	}

	public static RoomDto entityToDto(Room entity) {
		RoomDto dto = new RoomDto();
		dto.setId(entity.getId());
		if (entity.getId() != null) {
			dto.setId(entity.getId());
			dto.setCapacity(entity.getCapacity());
			dto.setDailyPrice(entity.getDailyPrice());
			dto.setStatus(entity.getStatus());
			dto.setRoomHistories(RoomHistoryDto.convertList(entity.getRoomHistories()));
		} else {
			dto.setId(null);
		}
		return dto;
	}

	public static Room dtoToEntity(RoomDto dto) {
		Room room = new Room();
		room.setId(dto.getId());
		room.setCapacity(dto.getCapacity());
		room.setDailyPrice(dto.getDailyPrice());
		room.setStatus(dto.getStatus());
//		roomHistory.setRoomHistory(ServiceDto.convertList(dto.getServices()));
		return room;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(int dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getStatus() {
		return this.status.name();
	}

	public void setStatus(String status) {
		this.status = Status.valueOf(status);
	}

	public List<RoomHistoryDto> getRoomHistories() {
		return roomHistories;
	}

	public void setRoomHistories(List<RoomHistoryDto> roomHistories) {
		this.roomHistories = roomHistories;
	}

	public RoomDto(Room room) {
		this.id = room.getId();
		this.capacity = room.getCapacity();
		this.dailyPrice = room.getDailyPrice();
		this.status = Status.valueOf(room.getStatus());
	}

	public RoomDto() {
	}

}
