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

import com.runa.hotel.api.dto.GuestDto;
import com.runa.hotel.api.service.IGuestService;

@RestController
@RequestMapping(value = "/guests")
public class GuestController {

	@Autowired
	IGuestService guestService;

	@GetMapping
	public List<GuestDto> getAllGuests() {
		return guestService.getAllGuests();
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GuestDto addGuest(@RequestBody GuestDto guestDto) {
		return guestService.addGuest(guestDto);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateGuest(@PathVariable Long id, @RequestBody GuestDto guestDto) {
		 guestService.updateGuest(id, guestDto);
	}

	@GetMapping(value = "/{id}")
	public GuestDto getGuest(@PathVariable Long id) {
		return guestService.getGuestById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteGuest(@PathVariable Long id) {
		guestService.deleteGuestById(id);
	}
}