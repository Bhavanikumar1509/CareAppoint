package com.example.demo.dto;

public class AppointmentRequest {
	private Integer patient_id;
	private Integer appointment_id;
	public AppointmentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentRequest(Integer patient_id, Integer appointment_id) {
		super();
		this.patient_id = patient_id;
		this.appointment_id = appointment_id;
	}
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public Integer getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}
	@Override
	public String toString() {
		return "AppointmentRequest [patient_id=" + patient_id + ", appointment_id=" + appointment_id + "]";
	}
	
}
