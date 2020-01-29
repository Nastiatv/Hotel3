package com.runa.hotel.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.runa.hotel.api.dao.IRoomDao;
import com.runa.hotel.api.dao.IRoomHistoryDao;
import com.runa.hotel.api.dto.RoomHistoryDto;
import com.runa.hotel.api.service.IRoomHistoryService;
import com.runa.hotel.entities.RoomHistory;

@Service
@Transactional
public class RoomHistoryService implements IRoomHistoryService {

	@Autowired
	private IRoomHistoryDao roomHistoryDao;
	@Autowired
	private IRoomDao roomDao;
	

	public List<RoomHistoryDto> getAllRoomHistories() {
		return RoomHistoryDto.convertList(roomHistoryDao.getAll());
	}

	public RoomHistoryDto addRoomHistory(RoomHistoryDto roomHistoryDto) {
		RoomHistory roomHistory = new RoomHistory();
		roomHistory.setRoom(roomDao.get(roomHistoryDto.getRoomId()));
//		roomHistory.setGuestId(roomHistoryDto.getGuestId());
		return RoomHistoryDto.entityToDto(roomHistoryDao.create(roomHistory));
	}

	public RoomHistoryDto getRoomHistoryById(Long id) {
		return RoomHistoryDto.entityToDto(roomHistoryDao.get(id));
	}

	public void updateRoomHistory(Long id, RoomHistoryDto roomHistoryDto) {
		RoomHistory roomHistory = roomHistoryDao.get(id);

		if (!StringUtils.isEmpty(roomHistoryDto.getRoomId())) {
			roomHistory.setRoom(roomDao.get(roomHistoryDto.getRoomId()));
		}
//		if (roomHistory.getGuestId() != null) {
//			roomHistory.setGuestId(roomHistoryDto.getGuestId());
//		}
		roomHistoryDao.update(roomHistory);
	}

	public void deleteRoomHistoryById(Long id) {
		roomHistoryDao.delete(roomHistoryDao.get(id));
	}
}