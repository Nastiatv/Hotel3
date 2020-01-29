package com.runa.hotel.api.service;

import java.util.List;

import com.runa.hotel.api.dto.GuestDto;

public interface IGuestService {

	List<GuestDto> getAllGuests();

	GuestDto addGuest(GuestDto guestDto);

	GuestDto getGuestById(Long id);

	void deleteGuestById(Long id);

	void updateGuest(Long id, GuestDto guestDto);

}