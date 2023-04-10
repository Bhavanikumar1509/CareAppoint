package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Admin;
import com.example.demo.Entites.Doctor;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

	 Admin findByEmail(String email);
		
	}
		

