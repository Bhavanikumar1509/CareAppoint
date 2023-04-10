package com.example.demo.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.Entites.Appointment;
import com.example.demo.Entites.AppointmentStatus;
import com.example.demo.Entites.Doctor;
import com.example.demo.Entites.Patient;
@Component
public class AppointmentAvailableResponse {
	private Integer doctor_id;
	private String doctor_email;
	private String doctor_name;
	private String doctor_contact;
	private String specialization;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private double fee;
	private Integer appointment_id;
	private AppointmentStatus status;
	
	public AppointmentAvailableResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AppointmentAvailableResponse(Appointment appointment) {
		super();
		Doctor d = appointment.getDoctor();
		this.doctor_id = d.getDoctor_id();
		this.doctor_email = d.getEmail();
		this.doctor_name = d.getName();
		this.doctor_contact = d.getContact();
		this.specialization = d.getSpecialization();
		this.startTime = appointment.getStartTime();
		this.endTime=appointment.getEndTime();
		this.fee=appointment.getFee();
		this.status=appointment.getStatus();
		this.appointment_id=appointment.getAppointment_id();
		
		// TODO Auto-generated constructor stub
	}


	public Integer getDoctor_id() {
		return doctor_id;
	}


	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}


	public String getDoctor_email() {
		return doctor_email;
	}


	public void setDoctor_email(String doctor_email) {
		this.doctor_email = doctor_email;
	}


	public String getDoctor_name() {
		return doctor_name;
	}


	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}


	public String getDoctor_contact() {
		return doctor_contact;
	}


	public void setDoctor_contact(String doctor_contact) {
		this.doctor_contact = doctor_contact;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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


	public Integer getAppointment_id() {
		return appointment_id;
	}


	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}


	public AppointmentStatus getStatus() {
		return status;
	}


	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "AppointmentAvailableResponse [doctor_id=" + doctor_id + ", doctor_email=" + doctor_email
				+ ", doctor_name=" + doctor_name + ", doctor_contact=" + doctor_contact + ", specialization="
				+ specialization + ", startTime=" + startTime + ", endTime=" + endTime + ", fee=" + fee
				+ ", appointment_id=" + appointment_id + ", status=" + status + "]";
	}
	
	
	
	
	

}
