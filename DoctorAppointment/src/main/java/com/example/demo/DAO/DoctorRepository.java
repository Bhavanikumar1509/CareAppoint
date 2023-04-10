package com.example.demo.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

	Doctor findByEmail(String email);
	Optional<Doctor> findById(Integer doctor_id);
	List<Doctor> findBySpecialization(String specialization);
	


}
