package com.runa.hotel.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.runa.hotel.entities.RoomHistory;

public class RoomHistoryDto extends ADto {

	private long roomId;
	private List<GuestDto> guests;
	private List<ServiceDto> services;

	public static List<RoomHistoryDto> convertList(List<RoomHistory> entities) {
		List<RoomHistoryDto> roomHistories = new ArrayList<>();
		for (RoomHistory entity : entities) {
			RoomHistoryDto dto = new RoomHistoryDto();
			dto.setId(entity.getId());
			dto.setRoomId(entity.getRoom().getId());
			dto.setGuests(GuestDto.convertList(entity.getGuests()));
			dto.setServices(ServiceDto.convertList(entity.getServices()));
			roomHistories.add(dto);
		}
		return roomHistories;
	}

	public static RoomHistoryDto entityToDto(RoomHistory entity) {
		RoomHistoryDto dto = new RoomHistoryDto();
		dto.setId(entity.getId());
		dto.setRoomId(entity.getRoom().getId());
		dto.setGuests(GuestDto.convertList(entity.getGuests()));
		dto.setServices(ServiceDto.convertList(entity.getServices()));
		return dto;
	}

	public static RoomHistory dtoToEntity(RoomHistoryDto dto) {
		RoomHistory roomHistory = new RoomHistory();
		roomHistory.setId(dto.getId());
//		roomHistory.setGuestId(dto.getGuestId());
//		roomHistory.setRoomId(dto.getRoomId());
//		roomHistory.setServices(ServiceDto.convertList(dto.getServices()));
		return roomHistory;
	}

	public RoomHistoryDto() {
	}

	public RoomHistoryDto(RoomHistory roomHistory) {
		this.id = roomHistory.getId();
		this.roomId = roomHistory.getRoom().getId();
		this.guests = GuestDto.convertList(roomHistory.getGuests());
		this.services = ServiceDto.convertList(roomHistory.getServices());
	}

	public List<GuestDto> getGuests() {
		return guests;
	}

	public void setGuests(List<GuestDto> guests) {
		this.guests = guests;
	}

	public List<ServiceDto> getServices() {
		return services;
	}

	public void setServices(List<ServiceDto> services) {
		this.services = services;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long long1) {
		this.roomId = long1;
	}

}
