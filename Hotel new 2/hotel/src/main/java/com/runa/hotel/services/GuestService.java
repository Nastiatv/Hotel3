package com.runa.hotel.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.runa.hotel.api.dao.IGuestDao;
import com.runa.hotel.api.dto.GuestDto;
import com.runa.hotel.api.service.IGuestService;
import com.runa.hotel.entities.Guest;

@Service
@Transactional
public class GuestService implements IGuestService {

	@Autowired
	private IGuestDao guestDao;

	@Override
	public List<GuestDto> getAllGuests() {
		return GuestDto.convertList(guestDao.getAll());
	}

	@Override
	public GuestDto addGuest(GuestDto guestDto) {
		Guest guest = new Guest();
		guest.setId(guestDto.getId());
		return GuestDto.entityToDto(guestDao.create(guest));
	}

	@Override
	public GuestDto getGuestById(Long id) {
		return GuestDto.entityToDto(guestDao.get(id));
	}

	@Override
	public void updateGuest(Long id, GuestDto guestDto) {
		Guest existingGuest = guestDao.getAll().stream().filter(u -> u.getId().equals(id)).collect(Collectors.toList())
				.get(0);
		if (!StringUtils.isEmpty(guestDto.getId())) {
			existingGuest.setId(guestDto.getId());
		}
		guestDao.update(existingGuest);
	}

	@Override
	public void deleteGuestById(Long id) {
		guestDao.delete(guestDao.get(id));
	}

}
