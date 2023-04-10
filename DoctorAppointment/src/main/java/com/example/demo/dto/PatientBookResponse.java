package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.Entites.Appointment;
import com.example.demo.Entites.AppointmentStatus;
import com.example.demo.Entites.Doctor;
import com.example.demo.Entites.Patient;

public class PatientBookResponse {
	private String patient_email;
	private String patient_name;
	private String patient_contact;
	private String doctor_email;
	private String doctor_name;
	private String docotor_contact;
	private String doctor_specialization;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private double fee;
	private AppointmentStatus status;
	private Integer appointment_id;
	public PatientBookResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientBookResponse(Patient patient,Doctor doctor,Appointment appointment) {
		super();
		this.patient_email = patient.getEmail();
		this.patient_name = patient.getName();
		this.patient_contact = patient.getContact();
		this.doctor_email = doctor.getEmail();
		this.doctor_name = doctor.getName();
		this.docotor_contact = doctor.getContact();
		this.doctor_specialization = doctor.getSpecialization();
		this.startTime = appointment.getStartTime();
		this.endTime = appointment.getEndTime();
		this.fee = appointment.getFee();
		this.status = appointment.getStatus();
		this.appointment_id = appointment.getAppointment_id();
	}
	
	
	public String getPatient_email() {
		return patient_email;
	}
	public void setPatient_email(String patient_email) {
		this.patient_email = patient_email;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_contact() {
		return patient_contact;
	}
	public void setPatient_contact(String patient_contact) {
		this.patient_contact = patient_contact;
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
	public String getDocotor_contact() {
		return docotor_contact;
	}
	public void setDocotor_contact(String docotor_contact) {
		this.docotor_contact = docotor_contact;
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
		return "PatientBookResponse [patient_email=" + patient_email + ", patient_name=" + patient_name
				+ ", patient_contact=" + patient_contact + ", doctor_email=" + doctor_email + ", doctor_name="
				+ doctor_name + ", docotor_contact=" + docotor_contact + ", doctor_specialization="
				+ doctor_specialization + ", startTime=" + startTime + ", endTime=" + endTime + ", fee=" + fee
				+ ", status=" + status + ", appointment_id=" + appointment_id + "]";
	}
	
	
	
	
	
   

}
