package com.example.demo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DoctorAppointmentApplication;
import com.example.demo.Entites.Doctor;
import com.example.demo.Services.DoctorService;
import com.example.demo.dto.AppointmentAddRequest;
import com.example.demo.dto.DoctorLoginRequest;

@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	private final Logger logger=LoggerFactory.getLogger(DoctorAppointmentApplication.class);
	
	@PostMapping("/register")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        logger.info("New Dctor registered");
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody DoctorLoginRequest login) {
	      Doctor doctor = doctorService.login(login.getEmail(), login.getPassword());
	      if (doctor != null) {
	    	  logger.info("Dcotor Logged in");
	        return ResponseEntity.ok(doctor);
	      } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	      }
	    }
	@PostMapping("/addAppointment")
	public ResponseEntity<Object> addAppointment(@RequestBody AppointmentAddRequest add){
		logger.info("Doctor Added New Appointment");
		return ResponseEntity.ok(doctorService.add(add));
	}


}
