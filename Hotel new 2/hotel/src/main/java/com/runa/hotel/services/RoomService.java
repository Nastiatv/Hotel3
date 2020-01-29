package com.runa.hotel.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.runa.hotel.api.dao.IRoomDao;
import com.runa.hotel.api.dto.RoomDto;
import com.runa.hotel.api.service.IRoomService;
import com.runa.hotel.entities.Room;

@Service
@Transactional
public class RoomService implements IRoomService {

	@Autowired
	private IRoomDao roomDao;

	public List<RoomDto> getAllRooms() {
		return RoomDto.convertList(roomDao.getAll());
	}

	public RoomDto addRoom(RoomDto roomDto) {
		Room room = new Room();
		room.setCapacity(roomDto.getCapacity());
		room.setDailyPrice(roomDto.getDailyPrice());
		room.setStatus(roomDto.getStatus());
		return RoomDto.entityToDto(roomDao.create(room));
	}

	public RoomDto getRoomById(Long id) {
		return RoomDto.entityToDto(roomDao.get(id));
	}

	public void updateRoom(Long id, RoomDto roomDto) {
		Room room = roomDao.get(id);

		if (!StringUtils.isEmpty(roomDto.getStatus())) {
			room.setStatus(roomDto.getStatus());
		}
		if (room.getCapacity() != null) {
			room.setCapacity(roomDto.getCapacity());
		}
		if (room.getDailyPrice() != null) {
			room.setDailyPrice(roomDto.getDailyPrice());
		}
		roomDao.update(room);
	}

	public void deleteRoomById(Long id) {
		roomDao.delete(roomDao.get(id));
	}
}