package com.runa.hotel.api.dto;

import java.util.List;

import com.runa.hotel.entities.Guest;

public class GuestDto extends ADto {

	
	private List<RoomHistoryDto> roomHistories;

	
	public GuestDto(Guest guest) {
		this.id = guest.getId();
	}

	public GuestDto() {
	}

	public List<RoomHistoryDto> getRoomHistories() {
		return roomHistories;
	}

	public void setRoomHistories(List<RoomHistoryDto> roomHistories) {
		this.roomHistories = roomHistories;
	}

	public static List<GuestDto> convertList(List<Guest> entities) {
		List<GuestDto> guests = new java.util.ArrayList<>();
		for (Guest entity : entities) {
			GuestDto dto = new GuestDto();
			dto.setId(entity.getId());
			guests.add(dto);
		}
		return guests;
	}

	public static GuestDto entityToDto(Guest entity) {
		GuestDto dto = new GuestDto();
		dto.setId(entity.getId());
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		} else {
			dto.setId(null);
		}
		return dto;
	}

	public static Guest dtoToEntity(GuestDto dto) {
		Guest guest = new Guest();
		guest.setId(dto.getId());
		return guest;
	}
}
