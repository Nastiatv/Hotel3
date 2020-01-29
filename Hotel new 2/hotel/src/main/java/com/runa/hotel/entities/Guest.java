package com.runa.hotel.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "guests")
public class Guest extends AEntity {

	@ManyToMany
	@JoinTable(name = "relation_history_guest", 
	joinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "room_history_id", referencedColumnName = "id"))
	private List<RoomHistory> roomHistories;

	public Guest(Long id) {
		this.id = id;
	}

	public Guest() {
	}
}
