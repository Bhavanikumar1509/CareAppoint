package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AppointmentRepository;
import com.example.demo.DAO.DoctorRepository;
import com.example.demo.Entites.Appointment;
import com.example.demo.Entites.AppointmentStatus;
import com.example.demo.Entites.Doctor;
import com.example.demo.dto.AppointmentAddRequest;
import com.example.demo.dto.AppointmentAddResponse;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Doctor createDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	public Doctor login(String email, String password) {
		Doctor doctor=doctorRepository.findByEmail(email);
	    if (doctor != null && doctor.getPassword().equals(password)) {
		      return doctor;
		    }
		    return null;
		  }
	public AppointmentAddResponse add(AppointmentAddRequest appointmentAddRequest) {
		Doctor doctor = doctorRepository.findById(appointmentAddRequest.getDoctor_id()).get();
		Appointment appointment= new Appointment(
				doctor, 
				doctor.getSpecialization(),
				appointmentAddRequest.getStartTime(),
				appointmentAddRequest.getEndTime(),
				appointmentAddRequest.getFee(),
				AppointmentStatus.AVAILABLE
				);
		return new AppointmentAddResponse(appointmentRepository.save(appointment));
		
	}
	
	

}
