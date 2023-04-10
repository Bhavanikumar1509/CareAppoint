package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.Controllers.AdminController;
import com.example.demo.DAO.AdminRepository;
import com.example.demo.DAO.PatientRepository;
import com.example.demo.Entites.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(MockitoJUnitRunner.class)
class AdminControllerTest{
	private MockMvc mockMvc;
	ObjectMapper objectMapper=new ObjectMapper();
	ObjectWriter objectWriter=objectMapper.writer();
	@Mock
	private AdminRepository adminRepository;
	private PatientRepository patientRepository;
	
	@InjectMocks
	private AdminController adminController;
	
	Patient patient_1=new Patient(1, "hello", "world", "how", "918522469");
	Patient patient_2=new Patient(2, "hell", "worl", "ho", "91852246");
	
	@SuppressWarnings("deprecation")
	@Before
	 public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(adminController).build();
	}
	
	@Test
	public void getAllPatients_sucess() throws Exception{
		List<Patient> patients=new ArrayList<>();
		patients.add(patient_1);
		patients.add(patient_2);
		Mockito.when(patientRepository.findAll()).thenReturn(patients);
		mockMvc.perform(MockMvcRequestBuilders
				.get("/admin/patients")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}	
	
	}
	