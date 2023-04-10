package com.example.demo.Controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.example.demo.Entites.Appointment;
import com.example.demo.Entites.Patient;
import com.example.demo.Services.PatientService;
import com.example.demo.dto.AppointmentAvailableResponse;
import com.example.demo.dto.AppointmentRequest;
import com.example.demo.dto.PatientBookResponse;
import com.example.demo.dto.PatientLoginRequest;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService patientService;
    private final Logger logger=LoggerFactory.getLogger(DoctorAppointmentApplication.class);

    @PostMapping("/register")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        logger.info("new Patient Registered");
        return new ResponseEntity(createdPatient, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody PatientLoginRequest login) {
      Patient patient = patientService.login(login.getEmail(), login.getPassword());
      if (patient != null) {
    	  logger.info("Patient Loggedin");
        return ResponseEntity.ok(patient);
      } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
      }
    }
    @GetMapping("/appointments/available")
    public List<AppointmentAvailableResponse> getAppointments(@RequestParam(required=false, name="specialization") String specialization,
  		  @RequestParam(required=false,name="startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
  		  @RequestParam(required=false,name="endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime){
    	logger.info("Logged in patient checking available appointements");
      return patientService.getAppointments(specialization, startTime, endTime);
    }

    @PostMapping("/appointments/available/book")
    public PatientBookResponse bookAppointment(@RequestBody AppointmentRequest appointmentRequest) {
    	logger.info("Patient Booked Appointment");
    	System.out.println(appointmentRequest);
      return patientService.bookAppointment(appointmentRequest);
    }



}

