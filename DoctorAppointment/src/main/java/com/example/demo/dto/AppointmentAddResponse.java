package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.Entites.Appointment;
import com.example.demo.Entites.AppointmentStatus;

public class AppointmentAddResponse {
	
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private double fee;
	private AppointmentStatus status;
	private Integer appointment_id;
	public AppointmentAddResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentAddResponse(Appointment appointment) {
		super();
		this.startTime = appointment.getStartTime();
		this.endTime = appointment.getEndTime();
		this.fee = appointment.getFee();
		this.status = appointment.getStatus();
		this.appointment_id = appointment.getAppointment_id();
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
	public AppointmentStatus getStatus() {
		return status;
	}
	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
	public Integer getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}
	@Override
	public String toString() {
		return "AppointmentAddResponse [startTime=" + startTime + ", endTime=" + endTime + ", fee=" + fee + ", status="
				+ status + ", appointment_id=" + appointment_id + "]";
	}
	
	

}
