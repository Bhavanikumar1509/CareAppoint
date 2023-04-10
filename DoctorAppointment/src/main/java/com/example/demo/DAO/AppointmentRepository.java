package com.example.demo.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Appointment;
import com.example.demo.Entites.AppointmentStatus;

@Repository
public interface AppointmentRepository  extends JpaRepository<Appointment, Integer>{
	Optional<Appointment> findById(Integer appointment_id);

}
