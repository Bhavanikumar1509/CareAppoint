package com.example.demo.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DoctorAppointmentApplication;
import com.example.demo.Entites.Admin;
import com.example.demo.Services.AdminService;
import com.example.demo.Services.DoctorService;
import com.example.demo.dto.AdminLoginRequest;
import com.example.demo.dto.DoctorResponse;
import com.example.demo.dto.PatientResponse;
import com.example.demo.dto.viewAppointmentResponse;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	@Autowired
	private AdminService adminService;
	

	
	private final Logger logger=LoggerFactory.getLogger(DoctorAppointmentApplication.class);
	
	
	@PostMapping("/register")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        logger.info("Admin Created");
        return new ResponseEntity<>(createdAdmin,HttpStatus.CREATED);
    }
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody AdminLoginRequest login) {
	      Admin admin = adminService.login(login.getEmail(), login.getPassword());
	      if (admin != null) {
	    	  logger.info("Admin Logged in");
	        return ResponseEntity.ok(admin);
	      } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	      }
	    }
	@GetMapping("/patients")
	public List<PatientResponse> viewAllPatients(){
		logger.info("Admin is viewing Patients");
		return adminService.viewAllPatients();
		
	}
	
	@GetMapping("/doctors")
	public List<DoctorResponse> viewAllDoctors(@RequestParam(required=false, name="specialization") String specialization){
		if(specialization != null)
			return adminService.viewDoctorsBySpecialiazation(specialization);
			logger.info("Admin is Viewing Doctors");
		return adminService.viewAllDoctors();
	}
	@GetMapping("/appointments")
	public List<viewAppointmentResponse> viewAllAppointments(){
		return adminService.viewAllAppointments();
	}
	@GetMapping("/specializations")
	public List<String> getSpecializations(){
		return adminService.getSpecializations();
		
	}
	
	

}
