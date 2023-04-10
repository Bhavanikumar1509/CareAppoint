package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.Entites.Doctor;

@Component
public class DoctorResponse {
	
	private String email;
	private String name;
	private String contact;
	private String specialization;
	
	
	
	public DoctorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DoctorResponse(Doctor doctor){
		this.email = doctor.getEmail();
		this.name = doctor.getName();
		this.contact = doctor.getContact();
		this.specialization = doctor.getSpecialization();
	}
	

	public DoctorResponse(String email, String name, String contact, String specialization) {
		super();
		this.email = email;
		this.name = name;
		this.contact = contact;
		this.specialization = specialization;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	

}
