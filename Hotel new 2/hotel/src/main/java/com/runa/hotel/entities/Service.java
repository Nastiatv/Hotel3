package com.runa.hotel.entities;

import java.util.List;

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

	@Enumerated(EnumType.STRING)
	private Status status;

	private String name;

	@ManyToMany
	@JoinTable(name = "relation_history_service", 
	joinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "room_history_id", referencedColumnName = "id"))
	private List<RoomHistory> roomHistories;
	
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

	public List<RoomHistory> getRoomHistories() {
		return roomHistories;
	}

	public void setRoomHistory(List<RoomHistory> roomHistories) {
		this.roomHistories = roomHistories;
	}

	
	
	}
