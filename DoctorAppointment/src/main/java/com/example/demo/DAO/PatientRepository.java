package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{

	Patient findByEmail(String email);

}
