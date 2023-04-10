package com.example.demo.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AppointmentRepository;
import com.example.demo.DAO.PatientRepository;
import com.example.demo.Entites.Appointment;
import com.example.demo.Entites.AppointmentStatus;
import com.example.demo.Entites.Patient;
import com.example.demo.dto.AppointmentAvailableResponse;
import com.example.demo.dto.AppointmentRequest;
import com.example.demo.dto.PatientBookResponse;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Patient createPatient(Patient patient) {
        Patient p =  patientRepository.save(patient);
        System.out.println(p);
        return p;
    }

	public Patient login(String email, String password) {
		    Patient patient = patientRepository.findByEmail(email);
		    if (patient != null && patient.getPassword().equals(password)) {
		      return patient;
		    }
		    return null;
		  }
	
	 public List<AppointmentAvailableResponse> getAppointments(String specialization, LocalDateTime startTime, LocalDateTime endTime) {
   	  
   	  List<Appointment> appointments = appointmentRepository.findAll();
   	  
   	  if(specialization != null)
   		  appointments = appointments.stream().filter(a -> a.getSpecialization().equalsIgnoreCase(specialization)).toList();
   	  if(startTime != null )
   		  appointments = appointments.stream().filter(a -> a.getStartTime().equals(startTime)).toList();
       return appointments.stream().map(AppointmentAvailableResponse::new).toList();
     }

     public PatientBookResponse bookAppointment(AppointmentRequest appointmentRequest){
  
       Appointment appointment = appointmentRepository.findById(appointmentRequest.getAppointment_id()).get();
       appointment.setStatus(AppointmentStatus.BOOKED);
       
       appointment.setPatient(patientRepository.findById(appointmentRequest.getPatient_id()).get());
       
       Appointment app = appointmentRepository.save(appointment);
       return new PatientBookResponse(app.getPatient(), app.getDoctor(), app) ;
     }
	 
	
	 
	 
	 
	}


