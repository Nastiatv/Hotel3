package com.runa.hotel.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.runa.hotel.enums.Status;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "rooms")
public class Room extends AEntity {

	@Column(name = "capacity")
	private Integer capacity;

	@Column(name = "daily_price")
	private Integer dailyPrice;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<RoomHistory> roomHistories;

	public String getStatus() {
		return this.status.name();
	}

	public void setStatus(String status) {
		this.status = Status.valueOf(status);
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(Integer dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public List<RoomHistory> getRoomHistories() {
		return roomHistories;
	}

	public void setRoomHistories(List<RoomHistory> roomHistories) {
		this.roomHistories = roomHistories;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Room(int capacity, int dailyPrice, Status status) {
		this.capacity = capacity;
		this.dailyPrice = dailyPrice;
		this.status = status;
	}

	public Room() {
	}

}
