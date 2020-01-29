package com.runa.hotel.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.runa.hotel.entities.Service;
import com.runa.hotel.enums.Status;

public class ServiceDto extends ADto {

	private int dailyPrice;

	private Status status;

	private String name;

	private List<RoomHistoryDto> roomHistories;

	public static List<ServiceDto> convertList(List<Service> entities) {
		List<ServiceDto> services = new ArrayList<>();
		for (Service entity : entities) {
			ServiceDto dto = new ServiceDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setDailyPrice(entity.getDailyPrice());
			dto.setStatus(entity.getStatus());
			dto.setRoomHistories(RoomHistoryDto.convertList(entity.getRoomHistories()));
			services.add(dto);
		}
		return services;
	}

	public static ServiceDto entityToDto(Service entity) {
		ServiceDto dto = new ServiceDto();
		dto.setId(entity.getId());
		if (entity.getId() != null) {
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setDailyPrice(entity.getDailyPrice());
			dto.setStatus(entity.getStatus());
			if (entity.getRoomHistories() != null) {
				dto.setRoomHistories(RoomHistoryDto.convertList(entity.getRoomHistories()));
			} else {
				dto.setRoomHistories(null);
			}
		} else {
			dto.setId(null);
		}
		return dto;
	}

	public static Service dtoToEntity(ServiceDto dto) {
		Service service = new Service();
		service.setId(dto.getId());
		service.setName(dto.getName());
		service.setDailyPrice(dto.getDailyPrice());
		service.setStatus(dto.getStatus());
		return service;
	}

	public int getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(int dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setRoomHistories(List<RoomHistoryDto> list) {
		this.roomHistories = list;
	}

	public ServiceDto(Service service) {
		this.id = service.getId();
		this.dailyPrice = service.getDailyPrice();
		this.status = Status.valueOf(service.getStatus());
		this.name = service.getName();
		}

	public ServiceDto() {
	}

	

}