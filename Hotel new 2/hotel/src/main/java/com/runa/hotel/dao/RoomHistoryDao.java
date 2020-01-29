package com.runa.hotel.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.runa.hotel.api.dao.IRoomHistoryDao;
import com.runa.hotel.entities.RoomHistory;
import com.runa.hotel.entities.RoomHistory_;

@Repository
public class RoomHistoryDao extends AGenericDao<RoomHistory> implements IRoomHistoryDao{

	
	public RoomHistoryDao() {
		super(RoomHistory.class);
	}
	
	@Override
	public RoomHistory getById(Long id) {
		try {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<RoomHistory> cq = cb.createQuery(getGenericClass());
		Root<RoomHistory> rootEntry = cq.from(RoomHistory.class);
		CriteriaQuery<RoomHistory> all =cq.select(rootEntry).where(cb.equal(rootEntry.get(RoomHistory_.id), id));
		TypedQuery<RoomHistory> result = entityManager.createQuery(all);
		return result.getSingleResult();}
		catch(NoResultException e) {
			return null;
		}
	}
}
