package com.runa.hotel.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.runa.hotel.api.dao.IGuestDao;
import com.runa.hotel.entities.Guest;
import com.runa.hotel.entities.Guest_;

@Repository
public class GuestDao extends AGenericDao<Guest> implements IGuestDao {

	public GuestDao() {
		super(Guest.class);
	}

	@Override
	public Guest getById(Long id) {
		try {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Guest> cq = cb.createQuery(getGenericClass());
		Root<Guest> rootEntry = cq.from(Guest.class);
		CriteriaQuery<Guest> all =cq.select(rootEntry).where(cb.equal(rootEntry.get(Guest_.id), id));
		TypedQuery<Guest> result = entityManager.createQuery(all);
		return result.getSingleResult();}
		catch(NoResultException e) {
			return null;
		}
	}
}

