package com.example.demo.dto;

import org.springframework.stereotype.Component;
@Component
public class PatientResponse {
	private String email;
	private String name;
	private String contact;
	
	public PatientResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientResponse(String email, String name, String contact) {
		super();
		this.email = email;
		this.name = name;
		this.contact = contact;
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
	
	

}
