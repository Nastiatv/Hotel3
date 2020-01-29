package com.runa.hotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.runa.hotel.enums.Status;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "services")
public class Service extends AEntity {

	@Column(name = "daily_price")
	private Integer dailyPrice;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(name = "relation_history_service", 
	joinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "room_history_id", referencedColumnName = "id"))
	private RoomHistory roomHistory;
	
	public Integer getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(Integer dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status.name();
	}

	public void setStatus(String status) {
		this.status = Status.valueOf(status);
	}

	public Service(Integer dailyPrice, Status status, String name) {
		this.dailyPrice = dailyPrice;
		this.status = status;
		this.name = name;
	}

	public Service() {
	}

	public RoomHistory getRoomHistory() {
		return roomHistory;
	}

	public void setRoomHistory(RoomHistory roomHistory) {
		this.roomHistory = roomHistory;
	}
	
	}
