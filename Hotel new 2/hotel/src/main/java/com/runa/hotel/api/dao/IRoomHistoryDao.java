package com.runa.hotel.api.dao;

import com.runa.hotel.entities.RoomHistory;

public interface IRoomHistoryDao extends IAGenericDao<RoomHistory> {
	
	RoomHistory getById(Long id);

}