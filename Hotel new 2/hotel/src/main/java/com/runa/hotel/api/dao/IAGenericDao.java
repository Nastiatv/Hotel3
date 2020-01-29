package com.runa.hotel.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.runa.hotel.entities.AEntity;

@Repository
public interface IAGenericDao<T extends AEntity>  {
	
	Class<T> getGenericClass();
	
	T create(T entity);
	
	T get(Long id);
	
	void update (T entity);
	
	void delete (T entity);
	
	List<T> getAll();
	
}
