package com.example.demo.Entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patient_id;
	@Column(unique = true)
	@NonNull
	private String email;
	private String password;
	private String name;
	private String contact;
	@OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(Integer patient_id, String email, String password, String name, String contact) {
		super();
		this.patient_id = patient_id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.contact = contact;
	}
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", contact=" + contact + "]";
	}
	
	

}
