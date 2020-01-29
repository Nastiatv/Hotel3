package com.runa.hotel.api.dao;

import com.runa.hotel.entities.Guest;

public interface IGuestDao  extends IAGenericDao<Guest>  {

	Guest getById(Long id);

	}
