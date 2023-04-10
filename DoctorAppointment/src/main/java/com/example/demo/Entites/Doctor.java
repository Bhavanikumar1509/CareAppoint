package com.example.demo.Entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer doctor_id;
	@Column(unique = true)
	private String email;
	private String password;
	private String name;
	private String contact;
	private String specialization;
	@OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(Integer doctor_id, String email, String password, String name, String contact,
			String specialization) {
		super();
		this.doctor_id = doctor_id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.contact = contact;
		this.specialization = specialization;
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
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
	public String getSpecialization() {
		return this.specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	@Override
	public String toString() {
		return "Doctor [doctor_id=" + doctor_id + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", contact=" + contact + ", Specialization=" + specialization + "]";
	}
	
	
	
	
	
	
}
