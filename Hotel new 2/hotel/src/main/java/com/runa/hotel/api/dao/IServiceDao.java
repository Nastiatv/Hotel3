package com.runa.hotel.api.dao;

import com.runa.hotel.entities.Service;

public interface IServiceDao extends IAGenericDao<Service> {
	
	Service getById(Long id);

}

	
