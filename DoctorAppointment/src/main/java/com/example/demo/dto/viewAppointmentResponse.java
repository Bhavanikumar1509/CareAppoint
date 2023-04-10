package com.example.demo.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.Entites.Appointment;
import com.example.demo.Entites.AppointmentStatus;

@Component
public class viewAppointmentResponse {
	private  Integer patient_id;
	private String patient_name;
	private Integer doctor_id;
	private String doctor_name;
	private String doctor_specialization;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private double fee;
	private AppointmentStatus status;
	private Integer appointment_id;
	public viewAppointmentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public viewAppointmentResponse(Appointment appointment) {
		super();
		this.patient_id=appointment.getPatient()!=null ? appointment.getPatient().getPatient_id():null;
		this.patient_name=appointment.getPatient()!=null? appointment.getPatient().getName():null;
		this.doctor_id=appointment.getDoctor().getDoctor_id();
		this.doctor_name=appointment.getDoctor().getName();
		this.doctor_specialization = appointment.getSpecialization();
		this.startTime = appointment.getStartTime();
		this.endTime = appointment.getEndTime();
		this.fee = appointment.getFee();
		this.status = appointment.getStatus();
		this.appointment_id =appointment.getAppointment_id();
	}
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_specialization() {
		return doctor_specialization;
	}
	public void setDoctor_specialization(String doctor_specialization) {
		this.doctor_specialization = doctor_specialization;
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
		return "viewAppointmentResponse [patient_id=" + patient_id + ", patient_name=" + patient_name + ", doctor_id="
				+ doctor_id + ", doctor_name=" + doctor_name + ", doctor_specialization=" + doctor_specialization
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", fee=" + fee + ", status=" + status
				+ ", appointment_id=" + appointment_id + "]";
	}
	
	
	

}
