package com.example.demo.Services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AdminRepository;
import com.example.demo.DAO.AppointmentRepository;
import com.example.demo.DAO.DoctorRepository;
import com.example.demo.DAO.PatientRepository;
import com.example.demo.Entites.Admin;
import com.example.demo.Entites.Doctor;
import com.example.demo.Entites.Patient;
import com.example.demo.dto.DoctorResponse;
import com.example.demo.dto.PatientResponse;
import com.example.demo.dto.viewAppointmentResponse;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin login(String email, String password) {
		Admin admin=adminRepository.findByEmail(email);
	    if (admin != null && admin.getPassword().equals(password)) {
		      return admin;
		    }
		    return null;
		  }
	public List<PatientResponse> viewAllPatients(){
		
		List<PatientResponse> list=new ArrayList<PatientResponse>();
		for(Patient patient:patientRepository.findAll()) {
			list.add(new PatientResponse(patient.getEmail(), patient.getName(), patient.getContact()));
		}
		return list;
		
	}
	
	public List<DoctorResponse> viewAllDoctors(){
		
		return doctorRepository.findAll()
		        .stream()
		        .map(DoctorResponse::new)
		        .collect(Collectors.toList());

	}
	public List<viewAppointmentResponse> viewAllAppointments(){
		return appointmentRepository.findAll()
		.stream()
		.map(viewAppointmentResponse::new)
		.collect(Collectors.toList());
		
		
	}
	public List<String> getSpecializations() {
        List<String> specializations = new ArrayList<>();
        List<Doctor> doctors = doctorRepository.findAll();
        for (Doctor doctor : doctors) {
            if (!specializations.contains(doctor.getSpecialization())) {
                specializations.add(doctor.getSpecialization());
            }
        }
        return specializations;
    }
	
	
	public List<DoctorResponse> viewDoctorsBySpecialiazation(String specialization) {
		return doctorRepository.findBySpecialization(specialization)
		        .stream()
		        .map(DoctorResponse::new)
		        .collect(Collectors.toList());
	}
	
	
}
