  package com.example.demo.Entites;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


@Entity
@Table(name="Appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Appointment_id;
	@ManyToOne
    @JoinColumn(name = "patient_id", nullable = true)
	private Patient patient;
	@ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
	private String specialization;
	@NonNull
    private LocalDateTime startTime;

    @NonNull
    private LocalDateTime endTime;
	private double fee;
	 @Enumerated(EnumType.STRING)
	  @Column(nullable = false)
	    private AppointmentStatus status;
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Appointment(Doctor doctor, String specialization,
			LocalDateTime startTime, LocalDateTime endTime, double fee, AppointmentStatus status) {
		super();
		this.doctor = doctor;
		this.specialization = specialization;
		this.startTime = startTime;
		this.endTime = endTime;
		this.fee = fee;
		this.status = status;
	}


	public Integer getAppointment_id() {
		return Appointment_id;
	}
	public void setAppointment_id(Integer appointment_id) {
		Appointment_id = appointment_id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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
	public AppointmentStatus getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "Appointment [Appointment_id=" + Appointment_id + ", patient=" + patient + ", doctor=" + doctor
				+ ", specialization=" + specialization + ", startTime=" + startTime + ", endTime=" + endTime + ", fee="
				+ fee + ", status=" + status + "]";
	}
	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
	
	
	
}
