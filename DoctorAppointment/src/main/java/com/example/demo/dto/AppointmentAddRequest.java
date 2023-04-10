package com.example.demo.dto;

import java.time.LocalDateTime;

public class AppointmentAddRequest {
	private Integer doctor_id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private double fee;
	public AppointmentAddRequest(Integer doctor_id, LocalDateTime startTime, LocalDateTime endTime, double fee) {
		super();
		this.doctor_id = doctor_id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.fee = fee;
	}
	public AppointmentAddRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "AppointmentAddRequest [doctor_id=" + doctor_id + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", fee=" + fee + "]";
	}
	
	
	

}
