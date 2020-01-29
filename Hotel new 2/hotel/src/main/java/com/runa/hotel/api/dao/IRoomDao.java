package com.runa.hotel.api.dao;

import com.runa.hotel.entities.Room;


public interface IRoomDao extends IAGenericDao<Room> {
	
	Room getById(Long id);

}