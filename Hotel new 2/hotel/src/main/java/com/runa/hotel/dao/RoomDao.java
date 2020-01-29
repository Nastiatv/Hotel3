package com.runa.hotel.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.runa.hotel.api.dao.IRoomDao;
import com.runa.hotel.entities.Room;
import com.runa.hotel.entities.Room_;

@Repository
public class RoomDao extends AGenericDao<Room> implements IRoomDao{

	
	public RoomDao() {
		super(Room.class);
	}
	
	@Override
	public Room getById(Long id) {
		try {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> cq = cb.createQuery(getGenericClass());
		Root<Room> rootEntry = cq.from(Room.class);
		CriteriaQuery<Room> all =cq.select(rootEntry).where(cb.equal(rootEntry.get(Room_.id), id));
		TypedQuery<Room> result = entityManager.createQuery(all);
		return result.getSingleResult();}
		catch(NoResultException e) {
			return null;
		}
	}
}
