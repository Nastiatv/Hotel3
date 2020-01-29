package com.runa.hotel.api.service;

import java.util.List;

import com.runa.hotel.api.dto.ServiceDto;

public interface IServiceService {

	List<ServiceDto> getAllServices();

	ServiceDto addService(ServiceDto dto);

	ServiceDto getServiceById(Long id);

	void updateService(Long id, ServiceDto dto);

	void deleteServiceById(Long id);


}