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

import com.runa.hotel.api.dto.ServiceDto;
import com.runa.hotel.api.service.IServiceService;

@RestController
@RequestMapping(value = "/services")
public class ServiceController {
	
	@Autowired
	IServiceService serviceService;

	@GetMapping
	public List<ServiceDto> getAllServices() {
		return serviceService.getAllServices();
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceDto addService(@RequestBody ServiceDto serviceDto) {
		return serviceService.addService(serviceDto);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateService(@PathVariable Long id, @RequestBody ServiceDto serviceDto) {
		 serviceService.updateService(id, serviceDto);
	}

	@GetMapping(value = "/{id}")
	public ServiceDto getService(@PathVariable Long id) {
		return serviceService.getServiceById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteService(@PathVariable Long id) {
		serviceService.deleteServiceById(id);
	}
}