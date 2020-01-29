package com.runa.hotel.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "room_histories")
public class RoomHistory extends AEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room room;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roomHistories")
	private List<Guest> guests;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roomHistories")
	private List<Service> services;

	public RoomHistory() {
	}

	public RoomHistory(Room room) {
		this.room = room;
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
